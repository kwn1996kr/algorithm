import java.io.*;
import java.util.*;
/*	¹éÁØ 16434¹ø µå·¡°ï ¾Ø ´øÀü
 	2021 / 02 / 22
 */

class Pair{
	int t;
	int a;
	int h;
	
	Pair(int t,int a,int h){
		this.t = t;
		this.a = a;
		this.h = h;
	}
}
public class Main {
	static int n;
	static Pair[] arr;
	
	static boolean check(long atk,long h) {
		long HP = h;
		long ATK = atk;
		
		for(int i=0;i<n;i++) {
			if(arr[i].t==1) {
				long cnt = arr[i].h/ATK;
				if(arr[i].h%ATK==0) cnt--;
				
				HP -= cnt*arr[i].a;
				
				if(HP<=0)
					return false;
			}
			else {
				ATK+=arr[i].a;
				HP = Math.min(h, HP+arr[i].h);
			}
		}
		return true;
	}
	public static void main(String[] args) throws Exception{		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int atk = Integer.parseInt(st.nextToken());
		arr = new Pair[n];
		
		for(int i=0;i<n;i++) {	
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken()); 
			int a = Integer.parseInt(st.nextToken()); 
			int h = Integer.parseInt(st.nextToken()); 
			arr[i] = new Pair(t,a,h);
		}
		
		long left = 1;
        long right = (long)1e18 +4 ;
        long ans = 0;
        
		while(left<=right) {
			long mid = (left+right)/2;
			if(check(atk,mid)) {
				right = mid-1;
				ans = mid;
			}
			else {
				left = mid+1;
			}
		}
		System.out.println(ans);
	}
 }

