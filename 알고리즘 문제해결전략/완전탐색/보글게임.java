import java.io.*;
import java.util.*;
/*	보글게임
 *  2021/ 05 / 03
 */

public class Main {
	static char[][] arr = new char[5][5];
	static int[] dx = {-1,-1,0,1,1,1,0,-1};
	static int[] dy = {0,1,1,1,0,-1,-1,-1};
	static String word;
	static boolean[][][] visited;
	static boolean hasWord(int x,int y,int idx) {
		visited[x][y][idx] = true;
		if(word.charAt(idx)!=arr[x][y]) {
			return false;
		}
		if(idx==word.length()-1) {
			return true;
		}
		for(int i=0;i<8;i++) {
			int nx = dx[i] + x;
			int ny = dy[i] + y;
			if(nx<0||nx>=5||ny<0||ny>=5) {
				continue;
			}
			if(visited[nx][ny][idx+1]) {
				continue;
			}
			if(hasWord(nx,ny,idx+1)) {
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int c = Integer.parseInt(br.readLine());
		while(c-->0) {	
			for(int i=0;i<5;i++) {
				String line = br.readLine();
				arr[i] = line.toCharArray();
			}
			
			int n = Integer.parseInt(br.readLine());
			while(n-->0) {
				word = br.readLine();
				boolean check = false;
				visited = new boolean[5][5][10];
				
				for(int i=0;i<5;i++) {
					for(int j=0;j<5;j++) {
						if(hasWord(i,j,0)) {
							check=true;
							break;
						}
					}
					if(check) break;
				}
				sb.append(word+" ");
				sb.append(check ? "YES\n" : "NO\n");
			}
		}
		System.out.print(sb);
	}
}

