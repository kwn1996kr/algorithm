import java.io.*;
import java.util.*;
/*	백준_16236번_아기 상어
 *	2021/ 02 / 27
 */
class Shark{
	int x,y,time;
}
public class Main {
	static int n;
	static int shark_size,shark_eat;
	static Shark shark = new Shark();
	static int[][] map;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[20][20];
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==9) {
					shark.x = i;
					shark.y = j;
					shark.time = 0;
					shark_size = 2;
					shark_eat=0;
					map[i][j] = 0;
				}
			}
		}
		
		boolean is_update = true;
		
		while(is_update) {
			is_update = false;
			Queue<Shark> q = new LinkedList<>();
			boolean[][] visited = new boolean[20][20];
			visited[shark.x][shark.y] = true;
			q.add(shark);
			
			Shark candi = new Shark();
			candi.x= 20 ;candi.y = 20; candi.time =-1;
			
			while(!q.isEmpty()) {
				Shark cur = q.remove();
				if(candi.time!=-1 && candi.time<cur.time) {
					break;
				}
				
				if(map[cur.x][cur.y] < shark_size && map[cur.x][cur.y] != 0 ) {
					is_update = true;
					if(candi.x>cur.x || (candi.x==cur.x && candi.y>cur.y)) {
						candi = cur;
					}
				}
				
				for(int i=0;i<4;i++) {
					Shark next = new Shark();
					next.x = cur.x + dx[i];
					next.y = cur.y + dy[i];
					next.time = cur.time + 1;
					
					if(next.y<0 || next.y>=n || next.x<0 || next.x>=n) continue;
					if(visited[next.x][next.y]==false && shark_size >= map[next.x][next.y]) {
						visited[next.x][next.y]=true;
						q.add(next);
					}
					
				}
			}
			
			if(is_update) {
				shark = candi;
				shark_eat++;
				if(shark_eat==shark_size) {
					shark_size++;
					shark_eat = 0;
				}
				map[shark.x][shark.y] = 0;
			}
		}
		System.out.println(shark.time);
	}
 }

