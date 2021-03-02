import java.io.*;
import java.util.*;
/*	น้มุ_3190น๘_น์
 *	2021/ 03 / 02
 */
class Snake{
	int x,y;
	Snake(int x,int y){
		this.x = x;
		this.y = y;
	}
}
public class Main {
	static int n;
	static int[][] map;
	static boolean[][] visited;
	static Deque<Snake> dequeue = new ArrayDeque<>();
	static Map<Integer,String> list = new HashMap<>();
	static int[] dx = {0,-1,0,1};
	static int[] dy = {1,0,-1,0};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int [n][n];
		visited = new boolean [n][n];
		int k = Integer.parseInt(br.readLine());
		
		for(int i=0;i<k;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a-1][b-1] = 1;
		}
		
		int l = Integer.parseInt(br.readLine());
		for(int i=0;i<l;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			String s = st.nextToken();
			list.put(x, s);
		}
		
		int idx = 0;
		int time = 0;
		dequeue.add(new Snake(0,0));
		visited[0][0] = true;
		
		while(true) {
			Snake temp = dequeue.peekLast();
			time++;
			int nx =  temp.x + dx[idx];
			int ny =  temp.y + dy[idx];
			
			if((nx<0 || nx>=n || ny<0 || ny>=n)||visited[nx][ny]) {
				break;
			}				
			
			if(map[nx][ny]==1) {
				map[nx][ny] = 0;
			}
			else{
				Snake remove = dequeue.removeFirst();
				visited[remove.x][remove.y] = false;
			}
			
			dequeue.addLast(new Snake(nx,ny));
			visited[nx][ny] = true;
			
			if(list.containsKey(time)) {
				String s = list.get(time);
				if(s.equals("D")) {
					idx=(idx+3)%4;
				}
				else {
					idx=(idx+1)%4;
				}
			}
		}
		System.out.println(time);
	}
 }

