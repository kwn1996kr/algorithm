import java.io.*;
import java.util.*;
/*	백준 15658번 연산자 끼워놓기(2)
 	2021 / 02 / 18
 */
public class Main {
	static int n,max=Integer.MIN_VALUE,min=Integer.MAX_VALUE;
	static int[] arr;
	static int[] op;
	static void dfs(int value,int count) {
		if(count==n) {
			max = Math.max(max, value);
			min = Math.min(min, value);
			return;
		}
		for(int i=0;i<4;i++) {
			if(op[i]>0) {
				op[i]--;
				
				switch(i) {
					case 0 : dfs(value+arr[count],count+1); break;
					case 1 : dfs(value-arr[count],count+1); break;
					case 2 : dfs(value*arr[count],count+1); break;
					case 3 : dfs(value/arr[count],count+1); break;
				}
				op[i]++;
			}
		}
	}
	public static void main(String[] args) throws Exception{		
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 n = Integer.parseInt(br.readLine());
		 arr = new int[n];
		 StringTokenizer st = new StringTokenizer(br.readLine());
		 
		 for(int i=0;i<n;i++) {
			 arr[i] = Integer.parseInt(st.nextToken());
		 }
		 st = new StringTokenizer(br.readLine());
		 op = new int [4];
		 for(int i=0;i<4;i++) {
			 op[i] = Integer.parseInt(st.nextToken());
		 }
		 
		 dfs(arr[0],1);
		 
		 System.out.println(max);
		 System.out.println(min);
	}
 }

