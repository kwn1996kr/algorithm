import java.io.*;
import java.util.*;
/*	여행하는 외판원 문제(TSP1)
 *  2021/ 05 / 05
 */

public class Main {
	static int c,n;
	static double result;
	static double[][] dist;
	static boolean[] visited;
	static void dfs(int prev, double sum,int count) {
		if(count==n-1) {
			result = Math.min(sum, result);
			return;
		}
		visited[prev] = true;
		for(int i=0;i<n;i++) {
			if(visited[i]==false) {
			dfs(i,sum+dist[prev][i],count+1);
			}
		}
		visited[prev] = false;
		return;
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		c = Integer.parseInt(br.readLine());
		while(c-->0) {
			n = Integer.parseInt(br.readLine());
			dist = new double[n][n];
			visited = new boolean [n];
			for(int i=0;i<n;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0;j<n;j++) {
					dist[i][j] = Double.parseDouble(st.nextToken());
				}
			}
			
			result=Double.MAX_VALUE;
			
			for(int i=0;i<n;i++) {
				dfs(i,0,0);
			}
			
			System.out.println(result);
		}
	}
}