import java.io.*;
import java.util.*;
/*백준 1647번 도시 분할 계획
2020 / 02 / 15
*/
class Edge implements Comparable<Edge>{
	int A;
	int B;
	int C;
	
	Edge(int A,int B,int C){
		this.A = A;
		this.B = B;
		this.C = C;
	}
	
	@Override
	public int compareTo(Edge o) {
		return this.C-o.C;
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
	
	static boolean findparent(int[] parent, int x, int y) {
		x = getparent(parent,x);
		y = getparent(parent,y);
		if(x==y) return true;
		return false;
	} 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		ArrayList<Edge> list = new ArrayList<>();
		int[] parent = new int [n+1];
		for(int i=0;i<=n;i++) {
			parent[i] = i;
		}
		while(m-->0) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			list.add(new Edge(A,B,C));
		}
		
		Collections.sort(list);
		
		int sum = 0;
		int split_village = 0;
		for(int i=0;i<list.size();i++) {
			Edge temp = list.get(i);
			if(!findparent(parent,temp.A,temp.B)) {
				sum+=temp.C;
				unionparent(parent,temp.A,temp.B);
				split_village = temp.C;
			}
		}
		
		System.out.println(sum-split_village);
	}
 }

