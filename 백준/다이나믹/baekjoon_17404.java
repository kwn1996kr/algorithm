import java.util.*;
import java.io.*;
/*백준 17404번 RGB거리2
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
        int answer = Integer.MAX_VALUE;
        for(int i=0;i<3;i++) {
        	for(int j=0;j<3;j++) {
        		if(i==j) {
        			dp[0][j] = arr[0][j];
        		}
        		else {
        			dp[0][j] = 1000*1000+1;
        		}
        	}
        	
        	for(int k=1;k<n;k++) {
        		dp[k][0] = Math.min(dp[k-1][1],dp[k-1][2])+arr[k][0];
        		dp[k][1] = Math.min(dp[k-1][2],dp[k-1][0])+arr[k][1];
        		dp[k][2] = Math.min(dp[k-1][1],dp[k-1][0])+arr[k][2];
        	}
        	
        	for(int j=0;j<3;j++) {
        		if(i==j) continue;
        		answer = Math.min(answer, dp[n-1][j]);
        	}
        }
        System.out.println(answer);
    }
}
