import java.io.*;
import java.util.*;
/*백준 11404번 플로이드
2020 / 02 / 15
*/
public class Main {
	static int INF = 987654321;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int[][] d = new int [n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(i==j) {
					d[i][j] = 0;
				}
				else {
					d[i][j] = INF;
				}
			}
		}
		
		while(m-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			d[a-1][b-1] = Math.min(d[a-1][b-1], c);
		}
		
		for(int k=0;k<n;k++) {
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(d[i][k]+d[k][j]<d[i][j]) {
						d[i][j] = d[i][k]+d[k][j];
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(d[i][j]==INF) {
					sb.append(0+" ");
				}
				else {
					sb.append(d[i][j]+" ");
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
 }

