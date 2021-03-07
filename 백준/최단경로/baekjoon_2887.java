import java.io.*;
import java.util.*;
/*백준 2887번 행성 터널
2020 / 02 / 15
*/
class Point{
	int num;
	int x;
	int y;
	int z;
	
	Point(int num, int x, int y, int z) {
		this.num = num;
		this.x = x;
		this.y = y;
		this.z = z;
	}
}
class Edge implements Comparable<Edge>{
	int x;
	int y;
	int z;
	
	Edge(int x,int y,int z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public int compareTo(Edge o) {
		return this.z-o.z;
	}
}
public class Main {
	static int[] parent;
	static int getparent(int x) {
		if(parent[x]==x) return x;
		return parent[x] = getparent(parent[x]);
	}
	static void union(int x,int y) {
		x = getparent(x);
		y= getparent(y);
		if(x<y) parent[y] = x;
		else parent[x] = y;
	}
	static boolean findparent(int x,int y) {
		x = getparent(x);
		y= getparent(y);
		if(x==y) return true;
		return false;
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		parent = new int[n+1];
		ArrayList<Edge> list = new ArrayList<>();
		Point[] points = new Point[n];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());

			points[i] = new Point(i, x, y, z);
		}
		
		Arrays.sort(points,(o1,o2)->o1.x-o2.x);
		for (int i = 0; i < n-1; i++) {
			int weight = Math.abs(points[i].x - points[i + 1].x);

			list.add(new Edge(points[i].num, points[i + 1].num, weight));
		}
		
		Arrays.sort(points,(o1,o2)->o1.y-o2.y);
		for (int i = 0; i < n-1; i++) {
			int weight = Math.abs(points[i].y - points[i + 1].y);

			list.add(new Edge(points[i].num, points[i + 1].num, weight));
		}
		
		Arrays.sort(points,(o1,o2)->o1.z-o2.z);
		for (int i = 0; i < n-1; i++) {
			int weight = Math.abs(points[i].z - points[i + 1].z);

			list.add(new Edge(points[i].num, points[i + 1].num, weight));
		}
		
		Collections.sort(list);
		
		for(int i=0;i<n;i++) {
			parent[i] = i;
		}
		
		int sum = 0;
		for(int i=0;i<list.size();i++) {
			Edge temp = list.get(i);
			if(!findparent(temp.x,temp.y)) {
				sum+=temp.z;
				union(temp.x,temp.y);
			}
		}
		System.out.println(sum);
	}
 }

