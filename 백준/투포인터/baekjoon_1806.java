import java.io.*;
import java.util.*;

/*백준 1806번 부분합
2020 / 02 / 10
*/
public class Main {	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n+1];
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int length = 100001;
		int sum = arr[0];
		int first=0, second = 0;
		while(first<=second&&second<n){
			if(sum<s) {
				sum+=arr[++second];
			}
			else{
				length = Math.min(length, second-first+1);
				sum-=arr[first++];	
			}
		}
		
		if(length==100001) {
			System.out.println(0);
		}
		else {
			System.out.println(length);
		}
	}
 }