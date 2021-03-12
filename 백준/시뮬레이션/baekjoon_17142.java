import java.io.*;
import java.util.*;
/*	백준_17142번_연구소3
 *  2021/ 03 / 12
 */
class Pair{
	int x;
	int y;
	int time;
	
	Pair(int x,int y,int time){
		this.x = x;
		this.y = y;
		this.time = time;
	}
}	
public class Main {
	static int n,m,result = Integer.MAX_VALUE,empty_cnt;
	static int[][] arr = new int[50][50];
	static ArrayList<Pair> virus = new ArrayList<>();
	static boolean[] check;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	
	static void dfs(int start,int depth) {
		if(m==depth) {
			result = Math.min(result, bfs());
			return;
		}
		for(int i=start;i<virus.size();i++) {
			if(check[i]==false) {	
				check[i] = true;
				dfs(i+1,depth+1);
				check[i] = false;
			}
		}
	}
	static int bfs() {
		Queue<Pair> q  = new LinkedList<>();
		boolean[][] visited = new boolean[50][50];
				
		for(int i=0;i<virus.size();i++) {
			if(check[i]) { 
				q.add(new Pair(virus.get(i).x,virus.get(i).y,0));
				visited[virus.get(i).x][virus.get(i).y]=true;
			}
		}

		int zero_cnt = 0;		
		while(!q.isEmpty()) {
				Pair temp = q.poll();	
				if(arr[temp.x][temp.y]==0) {
					zero_cnt++;
				}
				if(empty_cnt==zero_cnt) {
					return temp.time;
				}
				for(int i=0;i<4;i++) {
					int nx = temp.x + dx[i];
					int ny = temp.y + dy[i];
					if(nx<0 || nx>=n || ny<0 || ny>=n) continue;
					if(visited[nx][ny]==true || arr[nx][ny]==1) continue;				
					q.add(new Pair(nx,ny,temp.time+1));
					visited[nx][ny] = true;
				}
		}		
		
		return Integer.MAX_VALUE;
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==2) {
					virus.add(new Pair(i,j,0));
				}
				else if(arr[i][j]==0) {
					empty_cnt++;
				}
			}
		}
		
		check = new boolean[virus.size()];
		dfs(0,0);
		
		if(result == Integer.MAX_VALUE) {
			System.out.println(-1);
		}
		else {
			System.out.println(result);
		}
	}
}