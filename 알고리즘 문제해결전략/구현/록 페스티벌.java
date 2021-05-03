import java.io.*;
import java.util.*;
/*	¶ô Æä½ºÆ¼¹ú
 *  2021/ 05 / 03
 */
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int c,n,l;
		
		c = Integer.parseInt(br.readLine());
		while(c-->0) {
			double answer = Double.MAX_VALUE;
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());
			int[] arr = new int[n+1];
			st = new StringTokenizer(br.readLine());
			for(int i=1;i<=n;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int[] sum = new int[n+1];
			for(int i=1;i<=n;i++) {
				sum[i] = sum[i-1]+arr[i];
			}
			
			for(int i=0;i<=n;i++) { 
				for(int j=i+l;j<=n;j++) {
					answer = Math.min(answer, (sum[j]-sum[i])/(double)(j-i));
				}
			}
			
			System.out.println(answer);
		}
	}
}