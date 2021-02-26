import java.io.*;
import java.util.*;
/* 백준_15683번_감시
   2021/  02  /25
 */
class Pair{
	int x;
	int y;
	Pair(int x,int y){
		this.x = x;
		this.y = y;
	}
}
public class Main {
	static int n,m,mn=0;
	static int[][] arr;
	static int[][] map;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static void copy_map(){
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				map[i][j] = arr[i][j];
			}
		}
	}
	
	static boolean OOB(int x,int y) {
		return (x<0 || x>=n || y<0 || y>=m);
	}
	static void upd(int x,int y,int dir) {
		dir%=4;
		while(true) {
			x += dx[dir];
			y += dy[dir];
			if(OOB(x,y) || map[x][y]==6) return;
			if(map[x][y]!=0) continue;
			map[x][y] = 7;
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayList<Pair> list = new ArrayList<>();
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		map = new int[n][m];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==0) {
					mn++;
				}
				if(arr[i][j]!=0&&arr[i][j]!=6) {
					list.add(new Pair(i,j));
				}
			}
		}
		
		for(int i=0;i<1<<(2*list.size());i++) {
			copy_map();
			int brute = i;
			for(int j=0;j<list.size();j++) {
				int dir = brute%4;
				brute /= 4;
				int x = list.get(j).x;
				int y = list.get(j).y;
				if(arr[x][y]==1) {
					upd(x,y,dir);
				}
				else if(arr[x][y]==2) {
					upd(x,y,dir);
					upd(x,y,dir+2);
				}
				else if(arr[x][y]==3) {
					upd(x,y,dir);
					upd(x,y,dir+1);
				}
				else if(arr[x][y]==4) {
					upd(x,y,dir);
					upd(x,y,dir+1);
					upd(x,y,dir+3);
				}
				else{
					upd(x,y,dir);
					upd(x,y,dir+1);
					upd(x,y,dir+2);
					upd(x,y,dir+3);
				}
			}
			int val = 0;
			for(int j=0;j<n;j++) {
				for(int k=0;k<m;k++) {
					if(map[j][k]==0) {
						val++;
					}
				}
			}
			
			mn = Math.min(mn, val);
		}
		
		System.out.println(mn);
	}
 }

