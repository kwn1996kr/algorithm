import java.io.*;
import java.util.*;
/*	백준 10830번 행렬 제곱
 	2021 / 02 / 18
 */
public class Main {
	static int n;
	static int[][] arr;
	static int[][] calculation(int[][] a,int[][] A){
		int[][] temp = new int[n][n];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				for(int k=0;k<n;k++) {
					temp[i][j] += a[i][k]*A[k][j];
				}
				temp[i][j] %= 1000;
			}
		}
		return temp;
	}
	static int[][] solution(int[][] arr,long b){
		if(b==1) {
			return arr;
		}
		else if(b%2==0) {
			int[][] temp = solution(arr,b/2);
			return calculation(temp,temp);
		}
		else {
			return calculation(solution(arr,b-1),arr);
		}
	}
	public static void main(String[] args) throws Exception{		
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	     StringTokenizer st = new StringTokenizer(br.readLine());
	     n = Integer.parseInt(st.nextToken());
	     long b = Long.parseLong(st.nextToken());
	     arr = new int[n][n];
	     int[][] result = new int[n][n];
	     
	     for(int i=0;i<n;i++) {
	    	 st = new StringTokenizer(br.readLine());
	    	 for(int j=0;j<n;j++) {
	    		 arr[i][j] = Integer.parseInt(st.nextToken());
	    	 }
	     }
	     result = solution(arr,b);
	     
	     for(int i=0; i<n; i++) {
	            for(int j=0; j<n; j++)
	                System.out.print(result[i][j]%1000+" ");
	            System.out.println();
	        }
	     
	}
 }

