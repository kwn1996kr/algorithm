import java.util.*;
import java.io.*;
/*	백준_17144번_미세먼지 안녕!
 *  2021/ 03/ 09
 */
class air_conditioner{
	int x;
	int y;
	
	air_conditioner(int x,int y){
		this.x = x;
		this.y = y;
	}
}
public class Main {
	static int r,c,t;
	static int[][] arr = new int[51][51];
	static ArrayList<air_conditioner> list = new ArrayList<>();
	static int[] dx = {0,-1,0,1};
	static int[] dy = {1,0,-1,0};
	static int[][] copy;
	
	static void bfs() {

		int[][] copy = new int[50][50];
		copy[list.get(0).x][0]=-1;
		copy[list.get(1).x][0]=-1;
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(arr[i][j]<=0) continue;
				
				int cnt=0;
				int difsu = arr[i][j]/5;
				for(int d=0; d<4; d++) {
                    int nx = i + dx[d];
                    int ny = j + dy[d];
                    
                    if(ny<0 || nx<0 || ny>=c || nx>=r) continue;
                    if(arr[nx][ny] == -1) continue;
                    
                    copy[nx][ny]+=difsu;
                    cnt++;
				}
				copy[i][j] += arr[i][j]-(cnt*difsu);
			}
		}
		
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				arr[i][j] = copy[i][j];
			}
		}
	}
	
	static void On_cleaner() {
		int top = list.get(0).x;
		int down = list.get(1).x;
		//반시계방향
		for(int i=top-1;i>0;i--) {
			arr[i][0] = arr[i-1][0];
		}
		for(int i=0;i<c-1;i++) {
			arr[0][i] = arr[0][i+1];
		}
		for(int i=0;i<top;i++) {
			arr[i][c-1] = arr[i+1][c-1];
		}
		for(int i=c-1;i>1;i--) {
			arr[top][i] = arr[top][i-1];
		}
		arr[top][1] = 0;
		
		//시계방향
		for(int i=down+1;i<r;i++) {
			arr[i][0] = arr[i+1][0];
		}
		for(int i=0;i<c-1;i++) {
			arr[r-1][i] = arr[r-1][i+1];
		}
		for(int i=r-1;i>down;i--) {
			arr[i][c-1] = arr[i-1][c-1];
		}
		for(int i=c-1;i>1;i--) {
			arr[down][i] = arr[down][i-1];
		}
		
		arr[down][1] = 0;
		
	}
	
	static int calculate() {
		int cnt = 0;
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(arr[i][j]>0) {
					cnt+=arr[i][j];
				}
			}
		}
		return cnt;
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<r;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<c;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==-1) {
					list.add(new air_conditioner(i,j));
				}
			}
		}
		
		while(t-->0) {
			bfs();
			
			On_cleaner();
		}
		
		calculate();
		System.out.println(calculate());
	}
}

