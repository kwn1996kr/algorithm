import java.io.*;
import java.util.*;

/*백준 9095번 1,2,3 더하기
2020 / 02 / 10
*/
public class Main {	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] dp =new int[12];
		dp[0] = 1;
		dp[1] = 1;
		for(int i=2;i<12;i++) {
			dp[i] += dp[i-1];
			if(i-2>=0) {
				dp[i] += dp[i-2];
			}
			if(i-3>=0) {
				dp[i] += dp[i-3];
			}
		}
		
		while(n-->0) {
			int num = Integer.parseInt(br.readLine());
			System.out.println(dp[num]);
		}
	}
 }