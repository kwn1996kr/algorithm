import java.io.*;
import java.util.*;

/*백준 2579번 계단 오르기
2020 / 02 / 10
*/
public class Main {	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n+1];
		int[][] dp = new int[n+1][2];
		
		for(int i=1;i<=n;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		dp[1][0] = arr[1];
		if(n>=2) {	
			dp[2][0] = arr[2];
			dp[2][1] =arr[1]+arr[2];
		}
		for(int i=3;i<=n;i++) {
			dp[i][0] = Math.max(dp[i-2][0]+arr[i], dp[i-2][1]+arr[i]);
			dp[i][1] = dp[i-1][0]+arr[i];
		}
		
		System.out.println(Math.max(dp[n][0], dp[n][1]));
	}
 }