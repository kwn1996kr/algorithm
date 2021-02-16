import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int n;
	static int[] inDegree;
	static ArrayList<Integer>[] list;
	static void topologySort() {
		ArrayList<Integer> answer = new ArrayList<>();
		Queue<Integer> q = new LinkedList<>();
		for(int i=1;i<=n;i++) {
			if(inDegree[i]==0) {
				q.add(i);
			}
		}
		
		while(!q.isEmpty()) {
			int temp = q.remove();
			answer.add(temp);
			
			for(int i:list[temp]) {
				inDegree[i]--;
				if(inDegree[i]==0) {
					q.add(i);
				}
			}
		}
		
		for(int i=0;i<answer.size();i++) {
			sb.append(answer.get(i)+" ");
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		inDegree = new int [n+1];
		list = new ArrayList [n+1];
		
		for(int i=0;i<=n;i++) {
			list[i] = new ArrayList<>();
		}
		while(m-->0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			inDegree[b]++;
		}
		topologySort();
		System.out.println(sb);
	}
 }

