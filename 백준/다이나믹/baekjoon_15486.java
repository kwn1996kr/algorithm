import java.io.*;
import java.util.*;

/*น้มุ 15486น๘ ล๐ป็ 2
2020 / 02 / 09
*/
public class Main {	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int max = Integer.MIN_VALUE;
		int[][] arr = new int[n+2][2];
		int[] dp = new int[n+2];
		for(int i=1;i<=n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<2;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=1;i<=n;i++) {
			max = Math.max(dp[i],max);
			
			if(i+arr[i][0]<=n) {
				dp[i+arr[i][0]] = Math.max(max+arr[i][1], dp[i+arr[i][0]]);
			}
		}
		System.out.println(max);
	}
 }