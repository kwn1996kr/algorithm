import java.io.*;
import java.util.*;
/* 백준_11375번_열혈강호
   2021/  02  /23
 */
public class Main {
	static int Max = 1001;
	static ArrayList<Integer>[] list;
	static int[] d;
	static boolean[] c;
	static int n,m,s;
	
	static boolean dfs(int x) {
		for(int i=0;i<list[x].size();i++) {
			int t = list[x].get(i);
			
			if(c[t]) continue;			
			c[t] = true;
			
			if(d[t]==0||dfs(d[t])) {
				d[t] = x;
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		list = new ArrayList[Max];
		d = new int [Max];
		c = new boolean[Max];
		
		for(int i=1;i<Max;i++) {
			list[i] = new ArrayList<>();
		}
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		for(int i=1;i<=n;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			for(int j=1;j<=s;j++) {
				int t =Integer.parseInt(st.nextToken());
				list[i].add(t);
			}
		}
		int count = 0;
		for(int i=1;i<=n;i++) {
			Arrays.fill(c, false);
			if(dfs(i)) count++;
		}
		
		System.out.println(count);
	}
 }

