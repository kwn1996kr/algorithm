import java.io.*;
import java.util.*;
/*	백준_11505번_구간 곱 구하기
 *  2021/ 03 / 22
 */
public class Main {
	static long[] arr;
	static long[] multiply;
	static long init(int start,int end,int node) {
		if(start==end) {
			return multiply[node] = arr[start];
		}
		int mid = (start+end)/2;
		return multiply[node] = (init(start,mid,node*2)*init(mid+1,end,node*2+1))%1000000007;
	}
	static long query(int start,int end,int node,int left,int right) {
		if(right<start||end<left) {
			return 1;
		}
		if(left<=start&&end<=right) {
			return  multiply[node];
		}
		int mid = (start+end)/2;
		return (query(start,mid,node*2,left,right)*query(mid+1,end,node*2+1,left,right))%1000000007;
	}
	static long update(int start,int end,int node,int index,long value) {
		if(index<start||index>end) {
			return multiply[node];
		}
	
		if(start==end) {
			return multiply[node]=arr[start]=value;
		}
		int mid = (start+end)/2;
		return multiply[node] = update(start,mid,node*2,index,value)*update(mid+1,end,node*2+1,index,value)%1000000007;
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		arr = new long[n+1];
		multiply = new long[4*n];
		for(int i=1;i<=n;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		init(1,n,1);
		int temp = m+k;
		for(int i=0;i<temp;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			if(a==1) {
				arr[b]=c;
				update(1,n,1,b,c);
			}
			else if(a==2){
				sb.append(query(1,n,1,b,(int)c)+"\n");
			}
		}
		System.out.println(sb);
	}
}