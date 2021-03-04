import java.io.*;
import java.util.*;
/*백준 1992번 쿼드트리
  2020 / 02 / 04
 */

public class Main {
	static int[][] arr;
	static StringBuilder sb = new StringBuilder();
	static void go(int x,int y, int size) {
		if(check(x,y,size)) {
			if(arr[x][y]==1) {
				sb.append(1);
			}
			else {
				sb.append(0);
			}
			return;
		}
		sb.append('(');
		go(x,y,size/2);
		go(x,y+size/2,size/2);
		go(x+size/2,y,size/2);
		go(x+size/2,y+size/2,size/2);	
		sb.append(')');
	}
	static boolean check(int x, int y,int size) {
		for(int i=x;i<x+size;i++) {
			for(int j=y;j<y+size;j++) {
				if(arr[x][y]!=arr[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		arr = new int[n][n]; 
		for(int i=0;i<n;i++) {
			String str = bf.readLine();
			for(int j=0;j<n;j++) {
				arr[i][j] = Integer.parseInt(str.substring(j,j+1));
			}
		}
		go(0,0,n);
		System.out.println(sb);
	}
}
