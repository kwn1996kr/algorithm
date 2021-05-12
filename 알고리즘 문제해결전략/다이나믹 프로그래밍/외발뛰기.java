import java.io.*;
import java.util.*;
/*	¿Ü¹ß ¶Ù±â
 *  2021/ 05/ 07
 */

public class Main {
	static int c,n;
	static int[][] map;
	static int[][] cache;
	static int solve(int x,int y) {
		if(x>=n || y>=n) {
			return 0;
		}
		if(x==n-1 && y==n-1) {
			cache[n-1][n-1] = 1;
			return 1;
		}
		if(cache[x][y]!=-1) {
			return cache[x][y];
		}
		return cache[x][y] = solve(x+map[x][y],y) | solve(x,y+map[x][y]);
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		c = Integer.parseInt(br.readLine());
		while(c-->0) {
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			cache = new int[n][n];
			
			for(int i=0;i<n;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0;j<n;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for(int i=0;i<n;i++) {
				Arrays.fill(cache[i], -1);
			}
			solve(0,0);
			if(cache[n-1][n-1]==1) {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}
		}
	}	
}