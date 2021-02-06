import java.util.*;
import java.io.*;
/*백준 1149번 RGB거리
2020 / 02 / 06
*/
public class Main {
	static int[][] arr;
	static int[][] dp;
    public static void main(String args[]) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        
        dp = new int[n][3];
        arr = new int[n][3];
        for(int i=0;i<n;i++) {
        	StringTokenizer st = new StringTokenizer(bf.readLine());
        	for(int j=0;j<3;j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        for(int i=0;i<3;i++) {
        	dp[0][i] = arr[0][i];
        }
        
        for(int k=1;k<n;k++) {
        	dp[k][0] = Math.min(dp[k-1][1],dp[k-1][2])+arr[k][0];
        	dp[k][1] = Math.min(dp[k-1][2],dp[k-1][0])+arr[k][1];
        	dp[k][2] = Math.min(dp[k-1][1],dp[k-1][0])+arr[k][2];
        }
        	
        int answer = dp[n-1][0];
        for(int i=1;i<3;i++) {
        	answer = Math.min(answer, dp[n-1][i]);
        }
        System.out.println(answer);
    }
}
