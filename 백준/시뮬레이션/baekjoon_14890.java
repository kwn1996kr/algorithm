import java.util.*;
import java.io.*;
/*	백준_14890번_경사로
 *  2021/ 03/ 08
 */
public class Main {
	static int[][] arr = new int[200][100];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				arr[i+n][j] = arr[j][i];
			}
		}
		
		int result = 0;
		int i,j;
		for(i=0;i<2*n;i++) {
			int cnt = 1;
			for(j=0;j<n-1;j++) {
				if(arr[i][j]==arr[i][j+1]) {
					cnt++;
				}
				else if(arr[i][j]+1 == arr[i][j+1] && cnt >= l) {
					cnt = 1;
				}
				else if(arr[i][j] == arr[i][j+1]+1 && cnt >= 0) {
					cnt = 1 - l;
				}
				else {
					break;
				}
			}
			if(j==n-1 && cnt>=0) {
				result++;
			}
		}
		System.out.println(result);
	}
}

