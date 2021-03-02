import java.io.*;
import java.util.*;
/*	백준_2098번_외판원 순회
 *	2021/ 03 / 02
 */
public class Main {
	static int n,INF = 987654321,min= 987654321;
	static int[][] arr;
	static int[][] dp;
	static int dfs(int node,int visit) {
		if(visit==(1<<n)-1) {
			if(arr[node][0]==0) {
				return INF;
			}
			return arr[node][0];
		}
		
		if(dp[node][visit]!=INF) {
			return dp[node][visit];
		}
		
		for(int i=0;i<n;i++) {
			int next = visit | (1<<i);
			if(arr[node][i]==0||((visit &(1<<i))!=0)) {
				continue;
			}
			dp[node][visit] = Math.min(dp[node][visit], dfs(i,next)+arr[node][i]);
		}
		return dp[node][visit];
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		dp = new int[n][1<<n];
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0;i<n;i++) {
			Arrays.fill(dp[i], INF);
		}
		
		dfs(0,1);
		System.out.println(dp[0][1]);
	}
 }

