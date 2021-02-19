import java.io.*;
import java.util.*;
/*	백준 11444번 피보나치 수 6
 	2021 / 02 / 18
 */
public class Main {
	static long[][] calculation(long[][] a,long[][] A){
		long[][] temp = new long[2][2];
		
		for(int i=0;i<2;i++) {
			for(int j=0;j<2;j++) {
				for(int k=0;k<2;k++) {
					temp[i][j] += a[i][k]*A[k][j];
				}
				temp[i][j]%= 1000000007;
			}
		}
		return temp;		
	}
	
	static long[][] solution(long[][] arr,long b){
		if(b==1) {
			return arr;
		}
		else if(b%2==0) {
			long[][] temp = solution(arr,b/2);
			return calculation(temp,temp);
		}
		else {
			return calculation(solution(arr,b-1),arr);
		}
	}
	public static void main(String[] args) throws Exception{		
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 long arr[][] = {{1,1},{1,0}};
		 long result[][] = new long [2][2];
		 StringBuilder sb = new StringBuilder();
		 long answer=0;
		 long n = Long.parseLong(br.readLine());
		 if(n==0) {
			 sb.append(0); 
		 }
		 else if(n==1) {
			 sb.append(1);
		 }
		 else if(n==2) {
			sb.append(1);
		 }
		 else {
		 	result = solution(arr,n);
		 	answer = result[0][1]%1000000007;
		 	sb.append(answer);
		 }
		 System.out.println(sb);
	}
 }

