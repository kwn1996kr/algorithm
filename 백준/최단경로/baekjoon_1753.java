import java.io.*;
import java.util.*;
/*백준 1753번 최단경로
2020 / 02 / 12
*/
class Edge implements Comparable<Edge>{
	int vertex;
	int weight;
	
	Edge(int vertex,int weight){
		this.vertex = vertex;
		this.weight = weight;
	}
	
	public int compareTo(Edge o) {
		return this.weight - o.weight;
	}	
}

public class Main {
	static int v;
	static int[] distance;
	static ArrayList<Edge>[] list;
	static void dijkstra(int start) {
		distance[start] = 0;
		PriorityQueue<Edge> q = new PriorityQueue<>();
		q.add(new Edge(start,0));
		
		while(!q.isEmpty()) {
			Edge temp = q.remove();
			int idx = temp.vertex;
			int dist = temp.weight;
			
			if(distance[idx]<dist) continue;
			
			for(Edge edge:list[idx]) {
				if(distance[edge.vertex]>distance[idx]+edge.weight) {
					distance[edge.vertex]=distance[idx]+edge.weight;
					q.add(new Edge(edge.vertex,distance[edge.vertex]));
				}
			}
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		
		int start = Integer.parseInt(br.readLine());
		
		list = new ArrayList[v+1];
		distance = new int[v+1];
		
		for(int i=0;i<=v;i++) {
			list[i] = new ArrayList<>();
		}
		Arrays.fill(distance,Integer.MAX_VALUE);
		
		for(int i=0;i<e;i++) {
			st = new StringTokenizer(br.readLine());
			int one = Integer.parseInt(st.nextToken());
			int two = Integer.parseInt(st.nextToken());
			int three = Integer.parseInt(st.nextToken());
			list[one].add(new Edge(two,three));
		}
		
		dijkstra(start);
		
		for(int i=1;i<=v;i++) {
			if(distance[i]==Integer.MAX_VALUE) {
				sb.append("INF\n");
			}
			else {
				sb.append(distance[i]+"\n");
			}
		}
		
		System.out.println(sb);
	}
 }