import java.io.*;
import java.util.*;
/* น้มุ 2150น๘ Strongly Connected Component
 	2021 / 02 / 17
 */
public class Main {
	static int id;
	static int[] d;
	static boolean[] visited;
	static Stack<Integer> stack = new Stack<>();
	static ArrayList<Integer>[] list;
	static ArrayList<ArrayList<Integer>> SCC = new ArrayList<ArrayList<Integer>>();
	
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
				if(top==x) break;
			}
			SCC.add(scc);
		}
		
		return parent;
		
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		list = new ArrayList[v+1];
		d = new int[v+1];
		visited = new boolean[v+1];
		
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
		for(int i=0;i<SCC.size();i++) {
			Collections.sort(SCC.get(i));
		}
		Collections.sort(SCC, new Comparator<ArrayList<Integer>>(){
			public int compare(ArrayList<Integer> o1,ArrayList<Integer> o2) {
				return o1.get(0) - o2.get(0);
			}
		});
		
		sb.append(SCC.size()+"\n");
		for(int i=0;i<SCC.size();i++) {
			for(int j=0;j<SCC.get(i).size();j++) {
				sb.append(SCC.get(i).get(j)+" ");
			}
			sb.append("-1\n");
		}
		
		System.out.println(sb);
	}
 }

