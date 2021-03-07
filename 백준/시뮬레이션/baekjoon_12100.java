import java.io.*;
import java.util.*;
/* น้มุ_12100น๘_2048(Easy)
   2021/  02  /26
 */

public class Main {
	static int n,result=0;
	static int[][] arr;
	static int[][] board;

	static void copy() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				board[i][j] = arr[i][j];
			}
		}
	}
	
	static void rotate() {
		int[][] tmp = new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				tmp[i][j] = board[i][j];
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				board[i][j] = tmp[n-1-j][i];
			}
		}		
	}
	static void tilt(int dir) {
		while(dir-->0) rotate();
		for(int i=0;i<n;i++) {
			int[] line = new int [n]; 
			int idx = 0;
			for(int j=0;j<n;j++) {
				if(board[i][j]==0) continue;
				if(line[idx]==0) {
					line[idx] = board[i][j];
				}
				else if(line[idx]==board[i][j]) {
					line[idx++] *= 2;
				}
				else {
					line[++idx] = board[i][j];
				}
			}
			for(int j=0;j<n;j++) {
				board[i][j] = line[j];
			}
		}
	} 
	static void count() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				result = Math.max(result, board[i][j]);
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		board = new int[n][n];
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int tmp=0;tmp<(1<<10);tmp++) {
			int brute=tmp;
			copy();
			for(int i=0;i<5;i++) {	
				int dir = brute%4;
				brute/= 4;
				tilt(dir);
			}
			count();
		}
		
		System.out.println(result);
	}
 }

