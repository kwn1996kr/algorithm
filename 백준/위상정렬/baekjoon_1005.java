import java.io.*;
import java.util.*;
/* 백준 1005번 ACM Craft
   2021 / 02 / 16
 */
public class Main {
	static StringBuilder sb = new StringBuilder();
	static int n,k;
	static int[] price;
	static int[] inDegree;
	static ArrayList<Integer>[] list;
	static void topologySort(int w) {
		Queue<Integer> q = new LinkedList<>();
		int[] result = new int [n+1];
		
		for(int i=0;i<=n;i++) {
			result[i] = price[i];
			if(inDegree[i]==0) {
				q.add(i);
			}
		}
		
		while(!q.isEmpty()) {
			int temp = q.remove();
			
			for(int i:list[temp]) {
				result[i] = Math.max(result[i], price[i]+result[temp]);
				inDegree[i]--;
				if(inDegree[i]==0) {
					q.add(i);
				}
			}
		}
		
		sb.append(result[w]+"\n");
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		while(testcase-->0) {	
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken()); // 건물의 개수
			k = Integer.parseInt(st.nextToken()); // 건설순서 규칙
			price = new int[n+1];
			inDegree = new int[n+1];
			list = new ArrayList [n+1];
			for(int i=0;i<=n;i++) {
				list[i] = new ArrayList<>();
			}
			st = new StringTokenizer(br.readLine());
			for(int i=1;i<=n;i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}
			for(int i=0;i<k;i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				list[a].add(b);
				inDegree[b]++;
			}
			int w = Integer.parseInt(br.readLine());
			topologySort(w);
		}
		System.out.println(sb);
	}
 }

