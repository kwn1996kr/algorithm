import java.io.*;
import java.util.*;
/*	백준_12015번_가장 긴 증가하는 부분 수열 2
 *  2021/ 03 / 30
 */
public class Main {
	static int[] arr;
	static int[] ans;
	static int binary_search(int start, int end,int target) {
		int mid;
		while(start<end) {
			mid = (start+end)/2;
			if(ans[mid]<target) {
				start = mid + 1;
			}
			else {
				end = mid;
			}
		}
		return end;
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new int[n];
		ans = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		ans[0]=arr[0];
		int index = 0;
		
		for(int i=1;i<n;i++) {
			if(ans[index]<arr[i]) {
				ans[++index]=arr[i];
			}
			else {
				int temp = binary_search(0,index,arr[i]);
				ans[temp]=arr[i];
			}
		}
		
		System.out.println(index+1);
	}
}
