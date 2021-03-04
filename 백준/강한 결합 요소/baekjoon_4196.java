import java.io.*;
import java.util.*;
/* 백준 4196번 도미노
 	2021 / 02 / 17
 */
public class Main {
	static int id;
	static int[] d;
	static boolean[] inDegree;
	static boolean[] visited;
	static int[] group;
	static Stack<Integer> stack = new Stack<>();
	static ArrayList<Integer>[] list;
	static ArrayList<ArrayList<Integer>> SCC;
	
	static int dfs(int x) {
		d[x] = ++id;
		stack.add(x);
		
		int parent = d[x];
		for(int i=0;i<list[x].size();i++) {
			int y = list[x].get(i);
			
			if(d[y]==0) parent = Math.min(parent, dfs(y));
			else if(!visited[y]) parent = Math.min(parent, d[y]);
		}
		
		if(parent==d[x]) {
			ArrayList<Integer> scc = new ArrayList<>();
			while(true) {
				int top = stack.peek();
				stack.pop();
				scc.add(top);
				visited[top] = true;
				group[top] = SCC.size()+1;
				if(top==x) break;
			}
			SCC.add(scc);
		}
		
		return parent;
		
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcase = Integer.parseInt(br.readLine()); 
		while(testcase-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			SCC = new ArrayList<ArrayList<Integer>>();
			list = new ArrayList[v+1];
			d = new int[v+1];
			visited = new boolean[v+1];
			inDegree = new boolean [v+1];
			group = new int [v+1];	
			
			for(int i=1;i<=v;i++) {
				list[i] = new ArrayList<>();
			}
			
			while(e-->0) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				list[a].add(b);
			}
		
			for(int i=1;i<=v;i++) {
				if(d[i]==0) dfs(i);
			}
		
			int count = 0;
		
			for(int i=1;i<=v;i++) {
				for(int j=0;j<list[i].size();j++) {
					int y = list[i].get(j);
					if(group[i]!=group[y]) { 
						inDegree[group[y]]=true;
					}
				}
			}
		
			for(int i=1;i<=v;i++) {
				if(!inDegree[i]) {
					count++;
				}
			}
		
			System.out.println(count);
		}
	}
 }

