import java.io.*;
import java.util.*;

/*백준 2294번 동전 2
2020 / 02 / 09
*/
public class Main {	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] arr= new int[n];
		int[] dp = new int[k+1];
		
		for(int i=0;i<=k;i++) {
			dp[i] = 10001;
		}
		
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		dp[0] = 0;
		for(int i=0;i<n;i++) {
			for(int j=arr[i];j<=k;j++) {
				dp[j] = Math.min(dp[j],dp[j-arr[i]]+1);
			}
		}
		
		if(dp[k]==10001) {
			System.out.println(-1);
		}
		else System.out.println(dp[k]);
	}
 }