import java.io.*;
import java.util.*;
/*	백준_10971번_외판원 순회2
 *	2021/ 03 / 02
 */
public class Main {
	static int n,min = Integer.MAX_VALUE;
	static int[][] arr;
	static boolean[] visited;
	static void dfs(int start,int prev,int cnt,int sum) {
		if(cnt==n && start==prev) {
			min = Math.min(min, sum);
			return;
		}
		for(int i=0;i<n;i++) {
			if(visited[i]) continue;
			if(arr[prev][i]==0) continue;
			visited[i] = true;
			dfs(start,i,cnt+1,sum+arr[prev][i]);
			visited[i]=false;
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		visited = new boolean[n];
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<n;i++) {
			dfs(i,i,0,0);
		}
		
		System.out.println(min);
	}
 }

