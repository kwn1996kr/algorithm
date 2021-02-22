import java.io.*;
import java.util.*;
/*	백준 14497번 주난의 난
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
	static int n,m,ans,x1,y1,x2,y2;
	static char[][] arr;
	static boolean[][] visited;
	static int[] dx = {0,-1,0,1};
	static int[] dy = {1,0,-1,0};
	static void bfs(int x1,int y1) {
		Queue<Pair> q = new LinkedList<>();
		Queue<Pair> next_q = new LinkedList<>();
		q.add(new Pair(x1,y1));
		visited[x1][y1] = true;
		
		while(!q.isEmpty()) {
			Pair temp = q.remove();
			
			if(temp.x==x2 && temp.y==y2) {
				return;
			}
			
			for(int i=0;i<4;i++) {
				int nx = temp.x + dx[i]; 
				int ny = temp.y + dy[i];
				if(nx>=1 && nx <= n && ny>=1 && ny<= m) {
					if(visited[nx][ny]==false&&arr[nx][ny]=='0') {
						visited[nx][ny] = true; 
						q.add(new Pair(nx,ny));
					}
					else if(visited[nx][ny]==false&&arr[nx][ny]=='1') {
						visited[nx][ny] = true; 
						next_q.add(new Pair(nx,ny));
					}
				}
			}
			if(q.isEmpty()) {
				q = next_q;
				next_q = new LinkedList<>();
				ans++;
			}
		}
		
	}
	public static void main(String[] args) throws Exception{		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new char[n+1][m+1];
		visited = new boolean[n+1][m+1];

		st = new StringTokenizer(br.readLine());
		x1 = Integer.parseInt(st.nextToken());
		y1 = Integer.parseInt(st.nextToken());
		x2 = Integer.parseInt(st.nextToken());
		y2 = Integer.parseInt(st.nextToken());
				
		for(int i=1;i<=n;i++) {
			String s = br.readLine();
			for(int j=1;j<=m;j++) {
				arr[i][j] = s.charAt(j-1);
			}
		}
		
		arr[x1][y1] = '0';
		arr[x2][y2] = '1';
		
		bfs(x1,y1);
					
		System.out.println(ans);
	}
 }

