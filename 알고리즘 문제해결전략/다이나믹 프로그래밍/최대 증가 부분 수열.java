import java.io.*;
import java.util.*;
/*	최대 증가 부분 수열
 *  2021/ 05/ 12
 */

public class Main {
	static int c,n,ans;
	static int[] arr;
	static int[] dp;
	static void solve() {
		for(int i=0;i<n;i++) {
			dp[i] = 1;
			for(int j=0;j<i;j++) {
				if(arr[j]<arr[i] && dp[j]+1>dp[i]) {
					dp[i] = dp[i]+1;
				}
			}
			ans = Math.max(dp[i], ans);
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		c = Integer.parseInt(br.readLine());
		while(c-->0) {
			n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr = new int [n];
			dp = new int [n];
			ans = 0;
			for(int i=0;i<n;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			solve();
			System.out.println(ans);
		}
	}	
}