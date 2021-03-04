import java.io.*;
import java.util.*;
/* 백준 20040번 사이클 게임
 	2021 / 02 / 17
 */
public class Main {
	static int n, m;
	static int[] parent;
	
	static int getparent(int x) {
		if(parent[x]==x) return x;
		return parent[x] = getparent(parent[x]);
	}
	
	static void unionparent(int x, int y) {
		x = getparent(x);
		y = getparent(y);
		if(x<y) {
			parent[y] = x;
		}
		else {
			parent[x] = y;
		}
		
		
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		parent = new int[n+1];
		
		for(int i=1;i<=n;i++) {
			parent[i] = i;
		}
		
		for(int i=1;i<=m;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(getparent(a)==getparent(b)) {
				System.out.println(i);
				return;
			}
			
			unionparent(a,b);
		}
		
		System.out.println(0);
		
	}
 }

