import java.util.*;
import java.io.*;
/*	백준_15685번_드래곤 커브
 *  2021/ 03/ 08
 */
public class Main {
	static int[][] arr;
	static int[] dx = {0,-1,0,1};
	static int[] dy = {1,0,-1,0};
	static ArrayList<Integer> list = new ArrayList<>();
	
	static void add_list(int d, int g) {
		list.clear();
		list.add(d);
		
		for(int i=0;i<g;i++) {			
			for(int j=list.size();j>0;j--) {
				list.add((list.get(j-1)+1)%4);
			}
		}
	}
	
	static void draw_dragoncurve(int x,int y) {
		
		arr[y][x] = 1;
		int nx = y;
		int ny = x;
		
		for(int a:list) {
			nx = nx + dx[a];
			ny = ny + dy[a];
			if(nx<0 || nx>=101 || ny<0 || ny>=101) continue;
			arr[nx][ny] = 1;
		}
	}
	
	static int find_rectangle() {
		int result=0;
		
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				if(arr[i][j]==1&&arr[i+1][j+1]==1&&arr[i+1][j]==1&&arr[i][j+1]==1) {
					result++;
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[101][101];
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken()); // 시작 방향
			int g = Integer.parseInt(st.nextToken()); // 세대
			
			add_list(d,g);
			draw_dragoncurve(x,y);
		}
		
		System.out.println(find_rectangle());
		
	}
}

