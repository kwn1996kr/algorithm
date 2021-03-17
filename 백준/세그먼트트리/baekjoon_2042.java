import java.io.*;
import java.util.*;
/*	백준_2042번_구간 합 구하기
 *  2021/ 03 / 18
 */
public class Main {
	static int n,m,k;
	static long[] arr;
	static long[] sum;
	static long init(int start,int end,int node) {
		if(start==end) {
			return sum[node] = arr[start];
		}
		int mid = (start+end)/2;
		return sum[node] = init(start,mid,node*2) + init(mid+1,end,node*2+1);
	}
	
	static long sum(int start,int end,int node,int left,int right) {
		if(right<start||left>end) {
			return 0;
		}
		if(left<=start&&end<=right) {
			return sum[node];
		}
		int mid = (start+end)/2;
		return sum(start,mid,node*2,left,right) + sum(mid+1,end,node*2+1,left,right);
	}
	
	static void update(int start,int end,int node,int index,long value) {
		if(index<start||index>end) {
			return;
		}
		sum[node] += value;
		if(start==end) {
			return;
		}
		int mid = (start+end)/2;
		update(start,mid,node*2,index,value);
		update(mid+1,end,node*2+1,index,value);
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new long[n+1];
		sum = new long[n*4];
		
		for(int i=1;i<=n;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int temp = m+k;
		
		init(1,n,1);
		for(int i=0;i<temp;i++) {
			st = st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			if(a==1) {
				long dif = c - arr[b];
				arr[b] = c;
				update(1,n,1,b,dif);
			}
			else if(a==2){
				sb.append(sum(1,n,1,b,(int)c)+"\n");
			}
		}
		System.out.println(sb);
	}
}