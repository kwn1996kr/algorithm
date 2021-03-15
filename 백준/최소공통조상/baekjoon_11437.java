import java.io.*;
import java.util.*;
/*	น้มุ_11437น๘_LCA
 *  2021/ 03 / 14
 */
public class Main {
	static ArrayList<Integer>[] tree;
	static int[] parent;
	static int[] depth;
	static boolean[] visit;
	static int n;
	static void dfs(int cur, int cnt) {
		depth[cur] = cnt;
		
		for(int node:tree[cur]) {
			if(depth[node]==0) {
				dfs(node,cnt+1);
				parent[node]=cur;
			}
		}
	}
	
	static int solve(int a,int b) {
		while(depth[a]>depth[b]) {
			a = parent[a];
		}
		while(depth[a]<depth[b]) {
			b = parent[b];
		}
		while(a!=b) {
			a=parent[a];
			b=parent[b];
		}
		return a;
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(br.readLine());
		tree = new ArrayList[n+1];
		for(int i=0;i<=n;i++) {
			tree[i] = new ArrayList<>();
		}
		for(int i=0;i<n-1;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			tree[node1].add(node2);
			tree[node2].add(node1);
		}
		depth = new int[n+1];
		parent = new int[n+1];
		
		dfs(1,1);
		int m = Integer.parseInt(br.readLine());
		for(int i=0;i<m;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			sb.append(solve(a,b)+"\n");
		}
		System.out.println(sb);
	}
}