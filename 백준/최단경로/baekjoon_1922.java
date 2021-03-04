import java.io.*;
import java.util.*;
/*백준 1922번 네트워크 연결
2020 / 02 / 15
*/
class Edge implements Comparable<Edge>{
	int x;
	int y;
	int weight;
	
	Edge(int x,int y,int weight){
		this.x = x;
		this.y = y;
		this.weight = weight;
	}
	
	@Override
	public int compareTo(Edge o) {
		return this.weight-o.weight;
	}
}
public class Main {
	static int getparent(int[] parent,int x) {
		if(parent[x]==x) return x;
		return parent[x] = getparent(parent,parent[x]);
	}
	
	static void unionparent(int[] parent, int x, int y) {
		x = getparent(parent,x);
		y = getparent(parent,y);
		if(x<y) parent[y]=x;
		else parent[x]=y;
	}
	
	static boolean findparent(int[] parent,int x,int y) {
		x = getparent(parent,x);
		y = getparent(parent,y);
		if(x==y) return true;
		else return false;
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		ArrayList<Edge> list = new ArrayList<>();
		
		while(m-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list.add(new Edge(a,b,c));
		}
		
		Collections.sort(list);
		
		int[] parent = new int[n];
		for(int i = 0; i<n;i++) {
			parent[i] = i;
		}
		
		int sum = 0;
		for(int i=0;i<list.size();i++) {
			Edge temp = list.get(i);
			if(!findparent(parent,temp.x-1,temp.y-1)) {
				sum+=temp.weight;
				unionparent(parent,temp.x-1,temp.y-1);
			}
		}
		System.out.println(sum);
	}
 }

