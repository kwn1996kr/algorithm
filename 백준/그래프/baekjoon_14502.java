import java.io.*;
import java.util.*;
/*	백준 14502번 연구소
 	2021 / 02 / 22
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
	static int n,m,ans;
	static int[][] arr;
	static int[][] map;
	static int[][] virus_map;
	static int[] dx = {0,-1,0,1};
	static int[] dy = {1,0,-1,0};
	static void bfs() {
		copy_virusmap();
		Queue<Pair> q = new LinkedList<>();
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(arr[i][j]==2) {
					q.add(new Pair(i,j));
				}
			}	
		}
		
		while(!q.isEmpty()) {
			Pair temp = q.remove();
			
			for(int i=0;i<4;i++) {
				int nx = temp.x+dx[i];
				int ny = temp.y+dy[i];
				
				if(nx>=0 && nx<n && ny>=0 && ny<m) {
					if(virus_map[nx][ny]==0) {
						virus_map[nx][ny]=2;
						q.add(new Pair(nx,ny));
					}
				}
			}
		}
		
		int count = 0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(virus_map[i][j]==0) count++;
			}				
		}
		
		ans = Math.max(ans, count);
	}
	
	static void copy_map() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				map[i][j]=arr[i][j];
			}
		}
	}
	
	static void copy_virusmap() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				virus_map[i][j]=map[i][j];
			}
		}
	}
	
	static void make_wall(int cnt) {
		if(cnt==3) {
			bfs();
			return;
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(map[i][j]==0) {
					map[i][j]=1;
					make_wall(cnt+1);
					map[i][j]=0;
				}
			}	
		}
	}
	public static void main(String[] args) throws Exception{		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		map = new int[n][m];
		virus_map = new int[n][m];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ans = 0;
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(arr[i][j]==0) {
					copy_map();
					map[i][j]=1;
					make_wall(1);
					map[i][j]=0;
				}
			}	
		}
	
		System.out.println(ans);
	}
 }

