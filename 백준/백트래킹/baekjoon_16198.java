import java.io.*;
import java.util.*;
/*	백준 16198번 에너지모으기
 	2021 / 02 / 18
 */
public class Main {
	static int n,ans=Integer.MIN_VALUE;
	static int[] arr;
	static boolean[] check;
	static void dfs(int sum,int count) {
		if(n-count==2) {
			ans = Math.max(ans, sum);
			return;
		}
		for(int i=1;i<n-1;i++) {
			if(check[i]==false) {
				check[i]=true;
				int l=i,r=i;
				while(check[l]) {
					l--;
				}
				while(check[r]) {
					r++;
				}
				dfs(sum+(arr[l]*arr[r]),count+1);
				check[i] = false;
			}
		}
	}
	public static void main(String[] args) throws Exception{		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		check = new boolean[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		dfs(0,0);
		
		System.out.println(ans);
	}
 }

