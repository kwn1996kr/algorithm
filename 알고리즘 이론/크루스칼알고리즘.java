package exercise8;
import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge>{
	int[] node = new int[2];
	int distance;
	
	Edge(int a,int b,int distance) {
		this.node[0] = a;
		this.node[1] = b;
		this.distance = distance;
	}
	
	public int compareTo(Edge o1) {
		return this.distance-o1.distance;
	}
}
public class Main {	
	static ArrayList<Edge> list = new ArrayList<>();
	
	static int getParent(int parent[],int x)  {
		if(parent[x]==x) return x;
		return parent[x] = getParent(parent,parent[x]);
	}
	static void unionParent(int parent[], int a,int b) {
		a = getParent(parent,a);
		b = getParent(parent,b);
		if(a<b) parent[b]=a;
		else parent[a]=b;		
	}
	
	static boolean findParent(int parent[], int a,int b) {
		a = getParent(parent,a);
		b = getParent(parent,b);
		if(a==b) return true;
		else return false;
	} 
	public static void main(String[] args) throws Exception{
		int n = 7;
		int m = 11;
		
		list.add(new Edge(1,7,12));
		list.add(new Edge(1,4,28));
		list.add(new Edge(1,2,67));
		list.add(new Edge(1,5,17));
		list.add(new Edge(2,4,24));
		list.add(new Edge(2,5,62));
		list.add(new Edge(3,5,20));
		list.add(new Edge(3,6,37));
		list.add(new Edge(4,7,13));
		list.add(new Edge(5,6,45));
		list.add(new Edge(5,7,73));
		
		Collections.sort(list);
		
		int[] parent = new int[n];
		for(int i=0;i<n;i++) {
			parent[i] = i;
		}
		
		int sum = 0;
		for(int i=0;i<list.size();i++) {
			Edge edge = list.get(i);
			if(!findParent(parent,edge.node[0]-1,edge.node[1]-1)) {
				sum+=edge.distance;
				unionParent(parent,edge.node[0]-1,edge.node[1]-1);
			}
		}
		
		System.out.println(sum);
	}
 }