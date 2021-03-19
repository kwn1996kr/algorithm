import java.io.*;
import java.util.*;
/*	백준_10868번_최솟값
 *  2021/ 03 / 18
 */
public class Main {
	static int n,m;
	static int[] arr;
	static int[] Min_range;
	
	static int init(int node,int left,int right) {
		if(left==right) {
			return Min_range[node]=arr[left];
		}
		int mid = (left+right)/2;
		return Min_range[node] = Math.min(init(node*2,left,mid),init(node*2+1,mid+1,right)); 
	}
	
/*	static int update(int index, int value,int node,int left,int right) {
		if(index<left||right<index) {
			return Min_range[node];
		}
		if(left==right) {
			return Min_range[node]=arr[index]=value;
		}
		int mid = (left+right)/2;
		return Min_range[node]=Math.min(update(index,value,node*2,left,mid),update(index,value,node*2+1,mid+1,right));
	}*/
	
	
	static int query(int start,int end,int node,int left,int right) {
		if(right<start || end<left) {
			return Integer.MAX_VALUE;
		}
		if(left<=start && end<=right) {
			return Min_range[node];
		}
		int mid = (start+end)/2;
		return Math.min(query(start,mid,node*2,left,right),query(mid+1,end,node*2+1,left,right));
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n+1];
		Min_range = new int[n*4];
		
		for(int i=1;i<=n;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}		
		init(1,1,n);
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			sb.append(query(1,n,1,a,b)+"\n");
		}
		
		System.out.println(sb);
	}
}