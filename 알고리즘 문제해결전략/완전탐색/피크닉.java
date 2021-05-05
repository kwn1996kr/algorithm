import java.io.*;
import java.util.*;
/*	¼ÒÇ³
 *  2021/ 05 / 04
 */

public class Main {
	static int c,n,m,cnt;
	static boolean[][] friend;
	static boolean[] hasfriend;
	static void dfs() {
		int check = -1;
		for(int i=0;i<n;i++) {
			if(hasfriend[i]==false) {
				check = i;
				break;
			}
		}
		if(check==-1) {
			cnt++;
			return;
		}
		for(int i=check+1;i<n;i++) {
			if(hasfriend[check]==false&&hasfriend[i]==false&&friend[check][i]==true) {
				hasfriend[check]=hasfriend[i]=true;
				dfs();
				hasfriend[check]=hasfriend[i]=false;
			}
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		c = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while(c-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			friend = new boolean[10][10];
			hasfriend = new boolean[10];
			cnt = 0;
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<m;i++) {	
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				friend[a][b] = true;
				friend[b][a] = true;
			}
			dfs();
			sb.append(cnt+"\n");
		}
		System.out.print(sb);
	}
}

