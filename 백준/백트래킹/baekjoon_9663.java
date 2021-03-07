import java.io.*;
import java.util.*;
/*น้มุ 9663น๘ N-Queen
2020 / 02 / 14
*/
public class Main {
	static int n;
	static int count = 0;
	static int[] arr;
	static boolean ispossible(int col) {
		for(int i=0;i<col;i++) {
			if(arr[col]==arr[i]) {
				return false;
			}
			else if(Math.abs(col-i)==Math.abs(arr[col] - arr[i])) {
				return false;
			}
		}
		return true;
	}
	static void dfs(int depth) {
		if(depth==n) {
			count++;
			return;
		}
		for(int i=0;i<n;i++) {
			arr[depth] = i;
			if(ispossible(depth)) {
				dfs(depth+1);
			}
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		
		dfs(0);
		System.out.println(count);
	}
 }