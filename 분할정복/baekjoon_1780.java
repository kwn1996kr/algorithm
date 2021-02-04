import java.io.*;
import java.util.*;
/*백준 1780번 종이의 개수
  2020 / 02 / 04
 */

public class Main {
	static int minus = 0;
	static int zero = 0;
	static int plus = 0;
	static int[][] arr;
	static boolean check(int x, int y , int size) {
		for(int i=x;i<x+size;i++) {
			for(int j=y;j<y+size;j++) {
				if(arr[x][y]!=arr[i][j])
					return false;
			}
		}
		return true;
	}
	static void go(int x, int y, int size) {
		if(check(x,y,size)) {
			if(arr[x][y]==-1) {
				minus++;
			}
			else if(arr[x][y]==0) {
				zero++;
			}
			else {
				plus++;
			}
			return;
		}
		go(x,y,size/3);
		go(x,y+size/3,size/3);
		go(x,y+size/3*2,size/3);
		
		go(x+size/3,y,size/3);
		go(x+size/3,y+size/3,size/3);
		go(x+size/3,y+size/3*2,size/3);
		
		go(x+size/3*2,y,size/3);
		go(x+size/3*2,y+size/3,size/3);
		go(x+size/3*2,y+size/3*2,size/3);
	}
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		arr = new int[n][n];
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for(int j=0;j<n;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		go(0,0,n);
		
		System.out.println(minus);
		System.out.println(zero);
		System.out.println(plus);
	}
}
