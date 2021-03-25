import java.io.*;
import java.util.*;

public class Main {
	static int id;
	static int[] d = new int[10001];
	static boolean[] visited = new boolean[10001];
	static Stack<Integer> stack = new Stack<>();
	static ArrayList<Integer>[] list = new ArrayList[10001];
	static ArrayList<Integer> scc;
	static ArrayList<ArrayList<Integer>> SCC = new ArrayList<ArrayList<Integer>>();
	static int dfs(int x) {
		d[x]=++id;
		stack.add(x);
		
		int parent = d[x];
		for(int i=0;i<list[x].size();i++) {
			int y = list[x].get(i);
			//방문하지 않은 이웃
			if(d[y]==0) parent = Math.min(parent, dfs(y));
			//처리중인 이웃
			else if(!visited[y]) parent =  Math.min(parent, d[y]);
		}
		
		if(parent == d[x]) {
			scc = new ArrayList<>();
			while(true) {
				int t = stack.peek();
				stack.pop();
				scc.add(t);
				visited[t] = true;
				if(t==x) break;
			}
			SCC.add(scc);
		}
		return parent;
	}

	public static void main(String[] args) throws Exception{
		int v = 11;
		for(int i=1;i<=11;i++) {
			list[i] = new ArrayList<>();
		}
		list[1].add(2);
		list[2].add(3);
		list[3].add(1);
		list[4].add(2);
		list[4].add(5);
		list[5].add(7);
		list[6].add(5);
		list[7].add(6);
		list[8].add(5);
		list[8].add(9);
		list[9].add(10);
		list[10].add(11);
		list[11].add(3);
		list[11].add(8);
		
		for(int i=1;i<=v;i++) {
			if(d[i]==0) dfs(i);
		}
		System.out.println("SCC의 갯수 :"+SCC.size());
		for(int i=0;i<SCC.size();i++) {
			System.out.print((i+1)+"번째 SCC:");
			for(int j=0;j<SCC.get(i).size();j++) {
				System.out.print(SCC.get(i).get(j)+" ");
			}
			System.out.println();
		}
	}
 }
