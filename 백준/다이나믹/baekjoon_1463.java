import java.io.*;
import java.util.*;

/*백준 1463번 1로 만들기
2020 / 02 / 10
*/
public class Main {	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] dp = new int [n+1];
		dp[1]=0;
		if(n>=2) {	
			dp[2]=1;
		}
		if(n>=3) {
			dp[3]=1;
		}
		for(int i=4;i<=n;i++) {
			dp[i] = dp[i-1]+1;
			if(i%2==0) {
				dp[i] = Math.min(dp[i/2]+1, dp[i]);
			}
			if(i%3==0) {
				dp[i] = Math.min(dp[i/3]+1, dp[i]);
			}			
		}
		
		System.out.println(dp[n]);
	}
 }