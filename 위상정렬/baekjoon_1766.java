import java.io.*;
import java.util.*;
/* 백준 1766번 문제집
   2021 / 02 / 16
 */
public class Main {
	static ArrayList<Integer>[] list;
	static int[] inDegree;
	static StringBuilder sb = new StringBuilder();
	static void topologySort(int n) {
		PriorityQueue<Integer> q = new PriorityQueue<>();
		
		for(int i=1;i<=n;i++) {
			if(inDegree[i]==0) {
				q.add(i);
			}
		}
		
		while(!q.isEmpty()) {
			int temp = q.remove();
			sb.append(temp+" ");
			
			for(int h : list[temp]) {
				inDegree[h]--;
				if(inDegree[h]==0) {
					q.add(h);
				}
			}			
		}
		
		
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[n+1];
		inDegree = new int[n+1];
		for(int i=1;i<=n;i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			inDegree[b]++;
		}
		
		topologySort(n);
		System.out.println(sb);
	}
 }

