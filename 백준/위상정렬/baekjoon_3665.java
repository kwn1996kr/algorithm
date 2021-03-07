import java.io.*;
import java.util.*;
/* 백준 3665번 최종 순위
   2021 / 02 / 16
 */
public class Main {
	static StringBuilder sb = new StringBuilder();
	static int[] rank;
	static boolean[][] graph;
	static int[] inDegree;
	static ArrayList<Integer>[] list;
	static void topologySort(int n) {
		ArrayList<Integer> result = new ArrayList<>();
		Queue<Integer> q = new LinkedList<>();
		
		for(int i = 1; i<=n;i++) {
			if(inDegree[i]==0) {
				q.add(i);
			}
		}
		
		for(int i=0;i<n;i++) {
			if(q.isEmpty()) {
				sb.append("IMPOSSIBLE\n");
				return;
			}
			if(q.size()>1) {
				sb.append("?\n");
			}
			
			int temp = q.remove();
			result.add(temp);
			
			for(int h:list[temp]) {
				inDegree[h]--;
				if(inDegree[h]==0) {
					q.add(h);
				}
			}
		}
		
		for(int i=0;i<result.size();i++) {
			sb.append(result.get(i)+" ");
		}
		sb.append("\n");
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		while(testcase-->0) {
			int n = Integer.parseInt(br.readLine());
			rank = new int[n+1];
			inDegree = new int[n+1];
			graph = new boolean[n+1][n+1];
			list = new ArrayList[n+1];
			for(int i=1;i<=n;i++) {
				list[i] = new ArrayList<>();
			}
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=1;i<=n;i++) {
				rank[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i = 1;i<=n;i++) {
				for(int j=i+1;j<=n;j++) {
					graph[rank[i]][rank[j]] = true;
					inDegree[rank[j]]++;
				}
			}
			
			int m = Integer.parseInt(br.readLine());
			
			for(int i=0;i<m;i++) {
				 st = new StringTokenizer(br.readLine());

	                int a = Integer.parseInt(st.nextToken());
	                int b = Integer.parseInt(st.nextToken());


	                if (graph[a][b] == true) {

	                    graph[a][b] = false;
	                    graph[b][a] = true;

	                    inDegree[a]++;
	                    inDegree[b]--;
	                } else {

	                    graph[b][a] = false;
	                    graph[a][b] = true;

	                    inDegree[a]--;
	                    inDegree[b]++;
	                }

				}
			
			for(int i = 1;i<=n;i++) {
				for(int j=1;j<=n;j++) {
					if(graph[i][j]==true) {
						list[i].add(j);
					}
				}
			}
			
			topologySort(n);
		}
		System.out.println(sb);
	}
 }

