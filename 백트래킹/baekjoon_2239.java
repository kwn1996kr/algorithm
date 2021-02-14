import java.io.*;
import java.util.*;
/*백준 2239번 스도쿠
2020 / 02 / 14
*/
public class Main {
	static int[][] arr = new int[9][9] ;
	static void dfs(int x,int y) {
		if(y==9) {
			dfs(x+1,0);
			return;
		}
		if(x==9) {
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<9;i++) {				
				for(int j=0;j<9;j++) {
					sb.append(arr[i][j]);
				}
				sb.append("\n");
			}
			System.out.println(sb);
			System.exit(0);
		}
		if(arr[x][y]==0) {
			for(int i=1;i<10;i++) {
				if(check(x,y,i)) {
					arr[x][y]=i;
					dfs(x,y+1);
					arr[x][y]=0;
				}
			}
			return;
		}
		dfs(x,y+1);
	}
	
	static boolean check(int x,int y,int value) {
		for(int i=0;i<9;i++) {
			if(arr[x][i]==value) {
				return false;
			}
		}
		
		for(int i=0;i<9;i++) {
			if(arr[i][y]==value) {
				return false;
			}
		}
		
		int row = (x/3)*3;
		int col = (y/3)*3;
		for(int i=row;i<row+3;i++) {
			for(int j=col;j<col+3;j++) {
				if(arr[i][j]==value) {
					return false;
				}
			}
		}
		
		return true;
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0;i<9;i++) {
			String str = br.readLine();
			for(int j=0;j<9;j++) {
				arr[i][j] = str.charAt(j)-'0';
			}
		}
		
		dfs(0,0);
	}
 }