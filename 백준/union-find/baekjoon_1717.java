import java.io.*;
import java.util.*;
/* 백준 1717번 집합의 표현
 	2021 / 02 / 17
 */
public class Main {
	static int n,m;
	static int[] parent;
	static int getparent(int x) {
		if(parent[x]==x) return x;
		return parent[x] = getparent(parent[x]);
	}
	static void unionparent(int x,int y) {
		x = getparent(x);
		y = getparent(y);
		if(x<y) parent[y] = x;
		else parent[x] = y;
	}
	static boolean findparent(int x,int y) {
		x = getparent(x);
		y = getparent(y);
		if(x==y) return true;
		return false;
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		parent = new int [n+1];
		for(int i=1;i<=n;i++) {
			parent[i] = i;
		}
		
		while(m-->0) {
			st = new StringTokenizer(br.readLine());
			int menu = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			switch(menu) {
				case 0:			
					unionparent(a,b);
					break;
				case 1:
					if(findparent(a,b)) {
						sb.append("YES\n");
					}
					else {
						sb.append("NO\n");
					}
					break;					
			}
		}
		System.out.println(sb);
	}
 }

