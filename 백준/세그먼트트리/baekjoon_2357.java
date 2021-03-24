import java.io.*;
import java.util.*;
/*	백준_1517번_버블 소트
 *  2021/ 03 / 23
 */
public class Main {
	static int[] arr;
	static int[] max;
	static int[] min;
	static int max_init(int start,int end,int node) {
		if(start==end) {
			return max[node] = arr[start];
		}
		int mid = (start+end)/2;
		return max[node] = Math.max(max_init(start,mid, node*2),max_init(mid+1,end, node*2+1));
	}
	static int min_init(int start,int end,int node) {
		if(start==end) {
			return min[node] = arr[start];
		}
		int mid = (start+end)/2;
		return min[node] = Math.min(min_init(start,mid, node*2),min_init(mid+1,end, node*2+1));
	}
	static int max_query(int start,int end,int node,int left,int right) {
		if(end<left||right<start) {
			return Integer.MIN_VALUE;
		}
		if(left<=start && end<=right) {
			return max[node];
		}
		int mid = (start+end)/2;
		return Math.max(max_query(start,mid,node*2,left,right),max_query(mid+1,end,node*2+1,left,right));
	}
	static int min_query(int start,int end,int node,int left,int right) {
		if(end<left||right<start) {
			return Integer.MAX_VALUE;
		}
		if(left<=start && end<=right) {
			return min[node];
		}
		int mid = (start+end)/2;
		return Math.min(min_query(start,mid,node*2,left,right),min_query(mid+1,end,node*2+1,left,right));
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		arr = new int[n+1];
		max = new int[n*4];
		min = new int[n*4];
		
		for(int i=1;i<=n;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		max_init(1,n,1);
		min_init(1,n,1);
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			sb.append(min_query(1,n,1,a,b)+" "+max_query(1,n,1,a,b)+"\n");
		}
		System.out.println(sb);
	}
}