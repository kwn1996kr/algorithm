import java.io.*;
import java.util.*;

/*백준 2003번 수들의 합 2
2020 / 02 / 10
*/
public class Main {	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int cnt = 0;
		for(int i=0;i<n;i++) {
			int sum = 0;
			for(int j=i;j<n;j++) {
				sum+=arr[j];
				if(sum==m) {
					cnt++;
				}
				else if(sum>m) {
					break;
				}
			}
		}
		System.out.println(cnt);
	}
 }