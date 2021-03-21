import java.io.*;
import java.util.*;
/*	백준_11659번_구간 합 구하기4
 *  2021/ 03 / 21
 */
public class Main {
	static int[] arr;
	static int[] sum;
	static int init(int start,int end,int node) {
		if(start==end) {
			return sum[node] = arr[start];
		}
		int mid = (start+end)/2;
		return sum[node] = init(start,mid,node*2)+init(mid+1,end,node*2+1);
	}
	
	static int result(int start,int end,int node,int left,int right) {
		if(end<left || right < start) {
			return 0;
		}
		if(left<=start&&end<=right) {
			return sum[node];
		}
		int mid = (start+end)/2;
		return result(start,mid,node*2,left,right)+result(mid+1,end,node*2+1,left,right);
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		arr = new int[n+1];
		sum = new int[n*4];
		
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		init(1,n,1);
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			sb.append(result(1,n,1,a,b)+"\n");
		}
		System.out.println(sb);
	}
}