import java.io.*;
import java.util.*;

/*백준 2293번 동전 1
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
		
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		dp[0] = 1;
		for(int i=0;i<n;i++) {
			for(int j=arr[i];j<=k;j++) {
				dp[j] += dp[j-arr[i]]; 
			}
		}
		
		System.out.println(dp[k]);
	}
 }