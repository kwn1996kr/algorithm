import java.io.*;
import java.util.*;

/*백준 2146번 다리 만들기
2021 / 02 / 09
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
	static int[][] arr;
	static int[][] graph;
	static int[][] dist;
	static boolean[][] check;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	static int n;
	
	static void dfs(int x,int y,int cnt) {
		if(check[x][y]==true) {
			return;
		}
		check[x][y] = true;
		graph[x][y]= cnt;
		
		for(int i=0;i<4;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx>=0 && nx<n && ny>=0 && ny<n) {
				if(arr[nx][ny]==1 && check[nx][ny]==false) {
					dfs(nx,ny,cnt);
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		check = new boolean[n][n];
		graph = new int[n][n];
		arr = new int[n][n];
		dist = new int[n][n];
		
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int cnt = 1;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(arr[i][j]==1) {
					dfs(i,j,cnt++);
				}
			}
		}
		
		Queue<Pair> q = new LinkedList<>();
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				dist[i][j] = -1;
				if(arr[i][j]==1) {
					q.add(new Pair(i,j));
					dist[i][j] = 0;
				}
			}
		}
		
		while(!q.isEmpty()) {
			Pair temp = q.remove();
			int ox = temp.x;
			int oy = temp.y;
			for(int i=0;i<4;i++) {
				int nx = ox + dx[i];
				int ny = oy + dy[i];
				if(nx>=0 && nx<n && ny>=0 && ny<n) {
					if(dist[nx][ny]==-1) {
						dist[nx][ny] = dist[ox][oy]+1;
						graph[nx][ny] = graph[ox][oy];
						q.add(new Pair(nx,ny));
					}
				}
			}
		}
		
		int ans = -1;
		for(int i=0;i<n;i++) {
    		for(int j=0;j<n;j++) {
    			for(int k=0;k<4;k++) {
    				int nx = i + dx[k];
    				int ny = j + dy[k];
    				if(nx>=0 && nx<n && ny>=0 && ny<n) {
    					if(graph[i][j]!=graph[nx][ny]) {
    						if(ans==-1 || ans > dist[i][j]+dist[nx][ny]) {
    							ans = dist[i][j]+dist[nx][ny];
    						}
    					}
    				}
    			}
    		}
		}
		
		System.out.println(ans);
	}
 }