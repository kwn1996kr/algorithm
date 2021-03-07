import java.io.*;
import java.util.*;
/* 백준_15686번_치킨 배달
   2021/  02  /26
 */
class Pair{
	int x;
	int y;
	Pair(int x,int y){
		this.x = x;
		this.y = y;
	}
}
public class Main {
	static int n,m,result = Integer.MAX_VALUE;
	static int[][] arr;
	static ArrayList<Pair> house;
	static ArrayList<Pair> chicken;
	static boolean[] visited;
	static void dfs(int start,int cnt) {
		if(cnt==m) {
			int sum = 0;
			for(int i=0;i<house.size();i++) {
				int temp = Integer.MAX_VALUE;
				for(int j=0;j<chicken.size();j++) {
					if(visited[j]) {
						int dist  = Math.abs(house.get(i).x-chicken.get(j).x)+
									Math.abs(house.get(i).y-chicken.get(j).y);						
						temp = Math.min(temp, dist);
					}
				}
				sum += temp;
			}
			result = Math.min(result, sum);
			return;
		}
		for(int i=start;i<chicken.size();i++) {
			visited[i] = true;
			dfs(i+1,cnt+1);
			visited[i] = false;
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][n];
		house = new ArrayList<>();
		chicken = new ArrayList<>();
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==1) house.add(new Pair(i,j));
				if(arr[i][j]==2) chicken.add(new Pair(i,j));
			}
		}
		visited = new boolean[chicken.size()];
		dfs(0,0);
		System.out.println(result);		
	}
 }

