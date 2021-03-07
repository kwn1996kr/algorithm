import java.io.*;
import java.util.*;
/*	백준 2206번 벽 부수고 이동하기
 	2021 / 02 / 19
 */
class Pair{
	int x;
	int y;
	int distance;
	int break_wall;
	
	Pair(int x,int y,int distance,int break_wall){
		this.x = x;
		this.y = y;
		this.distance = distance;
		this.break_wall = break_wall;
	}
}
public class Main {
	static int n,m,result;
	static int[][] arr;
	static int[][] check;
	static int[] dx = {0,-1,0,1};
	static int[] dy = {1,0,-1,0};

	static void  bfs(int x,int y) {
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(x,y,1,0));
		check[x][y] = 0;
		
		while(!q.isEmpty()) {
			Pair temp = q.poll();
			if(temp.x==n-1 && temp.y==m-1) {
				result = temp.distance;
				break;
			}
			for(int i=0;i<4;i++) {
				int nx = temp.x+dx[i];
				int ny = temp.y+dy[i];
				if(nx>=0 && nx<n && ny>=0 && ny<m) {
					if(check[nx][ny]>temp.break_wall) {
						if(arr[nx][ny]==0) {
							q.add(new Pair(nx,ny,temp.distance+1,temp.break_wall));
							check[nx][ny]=temp.break_wall;
						}
						else {
							if(temp.break_wall==0) {
								q.add(new Pair(nx,ny,temp.distance+1,temp.break_wall+1));
								check[nx][ny]=temp.break_wall+1;
							}
						}
					}
				}
			}
		}
	}
	public static void main(String[] args) throws Exception{		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int [n][m];
		check = new int [n][m];
		
		for(int i=0;i<n;i++) {
			String s = br.readLine();
			for(int j=0;j<m;j++) {	
				arr[i][j] = s.charAt(j)-'0'; 
				check[i][j] = Integer.MAX_VALUE;
			}
		}
		result = Integer.MAX_VALUE;
		
		bfs(0,0);
		
		if(result==Integer.MAX_VALUE) {
			System.out.println(-1);
		}
		else {
			System.out.println(result);
		}
	}
 }

