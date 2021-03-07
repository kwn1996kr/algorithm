import java.io.*;
import java.util.*;
/* 백준 1976번 여행 가자
 	2021 / 02 / 17
 */
public class Main {
	static boolean check;
	static int n, m;
	static int[] parent;
	
	static int getparent(int x) {
		if(parent[x]==x) return x;
		return parent[x] = getparent(parent[x]);
	}
	
	static void unionparent(int x, int y) {
		x = getparent(x);
		y = getparent(y);
		if(x<y) parent[y] = x;
		else parent[x] = y;
	}
	
	static boolean findparent(int x, int y) {
		x = getparent(x);
		y = getparent(y);
		if(x==y) return true;
		return false;
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		parent = new int [n+1];
		
		for(int i=1;i<=n;i++) {
			parent[i] = i;
		}
		
		for(int i=1;i<=n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1;j<=n;j++) {
				int b = Integer.parseInt(st.nextToken());
				if(b==1) {	
					unionparent(i,j);
				}
			}
		}
				
		StringTokenizer st = new StringTokenizer(br.readLine());
		check = true;
		int start = getparent(Integer.parseInt(st.nextToken()));
		for(int i=1;i<m;i++) {
			int now = Integer.parseInt(st.nextToken());
			if(start!=getparent(now)) {
				check = false;
			}
		}
		
		if(check) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
		
		
	}
 }

