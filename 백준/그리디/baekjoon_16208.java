import java.io.*;
import java.util.*;
/*	น้มุ_16208น๘_ฑอย๚ภฝ
 *  2021 / 05 / 16
 */
public class Main {
	static int n;
	static long sum=0,result=0;
	static long[] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new long[n];
		StringTokenizer st =new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i] = Long.parseLong(st.nextToken());
			sum+=arr[i];
		}
		
		for(int i=0;i<n-1;i++) {
			sum-=arr[i];
			result+=arr[i]*sum;
		}
		
		System.out.println(result);
	}	
}