import java.io.*;
import java.util.*;
/*	����_11048��_�̵��ϱ�
 *  2021/ 05/ 10
 */

public class Main {
	static int n,m;
	static int[][] arr;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n+1][m+1];
		
		for(int i=1;i<=n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=m;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                arr[i][j] += Math.max(arr[i][j-1],Math.max(arr[i-1][j], arr[i-1][j-1]));
            }
        }
		
		System.out.println(arr[n][m]);
	}	
}