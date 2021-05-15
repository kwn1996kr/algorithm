import java.io.*;
import java.util.*;
/*	삼각형 위의 최대경로
 *  2021/ 05/ 12
 */

public class Main {
	static int c,n,result;
	static int[][] arr;
	static int[][] map;
	
	static int solve(int row, int col) {
		if(row==n-1) {
			return arr[row][col];
		}
		
		if(map[row][col]!=-1) {
			return map[row][col];
		}
		
		return map[row][col] = arr[row][col] + Math.max(solve(row+1,col) ,solve(row+1,col+1)); 
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		c = Integer.parseInt(br.readLine());
		while(c-->0) {
			result = 0;
			n = Integer.parseInt(br.readLine());
			arr = new int[n][n];
			map = new int[n][n];
			for(int i=0;i<n;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0;j<=i;j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0;i<n;i++) {
				Arrays.fill(map[i], -1);
			}
			
			System.out.println(solve(0,0));
		}
	}	
}