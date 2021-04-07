import java.io.*;
import java.util.*;
/*	백준_1197번_최소 스패닝 트리
 *  2021/ 04 / 07
 */
class Edge implements Comparable<Edge>{
	int[] node = new int[2];
	int distance;
	
	Edge(int x,int y,int distance) {
		this.node[0] = x;
		this.node[1] = y;
		this.distance = distance;
	}
	
	public int compareTo(Edge o1) {
		return this.distance-o1.distance;
	}
}
public class Main {
	static int[] parent;
	static ArrayList<Edge> list = new ArrayList<>();
	static int getParent(int x) {
		if(parent[x]==x) return x;
		return parent[x]=getParent(parent[x]);
	}
	static void unionParent(int a,int b) {
		a = getParent(a);
		b = getParent(b);
		if(a<b) parent[b] = a;
		else parent[a] = b;
	}
	static boolean findParent(int a,int b) {
		a = getParent(a);
		b = getParent(b);
		if(a==b) return true;
		else return false;
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		parent = new int[v+1];
	
		for(int i=1;i<=v;i++) {
			parent[i]=i;
		}
		
		for(int i=0;i<e;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken()); 
			list.add(new Edge(a,b,c));
		}
		
		Collections.sort(list);
		int sum = 0;
		
		for(int i=0;i<list.size();i++) {
			Edge edge = list.get(i);
			if(!findParent(edge.node[0],edge.node[1])) {
				unionParent(edge.node[0],edge.node[1]);
				sum+=edge.distance;
			}
		}
		
		System.out.println(sum);
	}
}
