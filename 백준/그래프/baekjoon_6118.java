import java.io.*;
import java.util.*;
/*	백준 6118번 숨바꼭질
 	2021 / 02 / 22
 */
public class Main {
	static int n,m;
	static ArrayList<Integer>[] list;
	static int[] arr;
	static boolean[] visited;
	
	static void bfs(int x) {
		Queue<Integer> q = new LinkedList<>();
		q.add(x);
		arr[x] = 0;
		visited[x] = true;
		
		while(!q.isEmpty()) {
			int temp = q.remove();
			for(int i:list[temp]) {
				if(visited[i]==false) {	
					arr[i] = arr[temp]+1;
					visited[i] = true;
					q.add(i);
				}
			}
		}
	}
	public static void main(String[] args) throws Exception{		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		list = new ArrayList[n+1];
		arr = new int[n+1];
		visited = new boolean[n+1];
		for(int i=1;i<=n;i++) {
			list[i] = new ArrayList<>();
		}
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		
		bfs(1);
		
		
		int where=n;
		int ans=1;
		for(int i=1;i<=n;i++) {
			ans = Math.max(ans, arr[i]);
		}
		int count=0;
		for(int i=1;i<=n;i++) {
			if(ans==arr[i]) {
				count++;
				where = Math.min(where, i);
			}
		}
		System.out.println(where+" "+ans+" "+count);
	}
 }

