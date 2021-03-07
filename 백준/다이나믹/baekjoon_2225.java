import java.io.*;
/*백준 2225번 합분해
2020 / 02 / 06
*/
public class Main {	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] str = bf.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int k = Integer.parseInt(str[1]);
		
		long [][] dp = new long [k+1][n+1];
		dp[0][0]=1;
		for(int i=1;i<=k;i++) {
			for(int j=0;j<=n;j++) {
				for(int l=0;l<=j;l++) {
					dp[i][j]+=dp[i-1][j-l];
					dp[i][j]%= 1000000000;
				}
			}
		}
		
		bw.write(String.valueOf( dp[k][n]% 1000000000));
		bw.flush();
	}
 }