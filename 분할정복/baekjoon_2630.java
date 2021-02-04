import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*백준 2630번 색종이 만들기
  2020 / 02 / 04
 */

public class Main {
	static int[][] arr;
	static int white =0;
	static int blue = 0;
	static void go(int x,int y,int size) {
		if(size==1) {
			return;
		}
		int color=arr[x][y];
		for(int i=x;i<x+size;i++) {
			for(int j=y;j<y+size;j++) {
				if(arr[i][j]!=color) {
					go(x,y,size/2);
					go(x,y+size/2,size/2);
					go(x+size/2,y,size/2);
					go(x+size/2,y+size/2,size/2);					
				}
			}
		}
		if(color==1) {
			blue++;
		}
		else {
			white++;
		}
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		arr = new int [n][n];
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for(int j=0;j<n;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		go(0,0,n);
		
		System.out.println(white);
		System.out.println(blue);
	}
}
