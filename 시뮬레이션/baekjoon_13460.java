import java.io.*;
import java.util.*;
/*	백준_13460번_구슬 탈출 2
 * 	2021/ 03/ 03
 */
class INFO{
	int rx,ry,bx,by,count;
}
public class Main {
	static INFO start = new INFO();
	static char[][] map;
	static int[] dx = {-1,1,0,0}; 
	static int[] dy = {0,0,-1,1};
	
	static int bfs() {
		int[][][][] visited = new int [10][10][10][10];
		Queue<INFO> q = new LinkedList<>();
		q.add(start);
		visited [start.rx][start.ry][start.bx][start.by] = 1;
		
		int ret = -1;
		while(!q.isEmpty()) {
			INFO cur = q.remove();
			if(cur.count>10) break;
			if(map[cur.rx][cur.ry]=='O'&& map[cur.bx][cur.by]!='O') {
				ret = cur.count;
				break;
			}
			
			for(int dir=0;dir<4;dir++) {
				int next_rx = cur.rx;
				int next_ry = cur.ry;
				int next_bx = cur.bx;
				int next_by = cur.by;
				
				while(true) {
					if(map[next_rx][next_ry] != '#' && map[next_rx][next_ry] !='O') {
						next_rx += dx[dir];
						next_ry += dy[dir];
					}
					else {
						if(map[next_rx][next_ry] == '#') {
							next_rx -= dx[dir];
							next_ry -= dy[dir];
						}
						break;
					}
				}
				while(true) {
					if(map[next_bx][next_by] != '#' && map[next_bx][next_by] !='O') {
						next_bx += dx[dir];
						next_by += dy[dir];
					}
					else {
						if(map[next_bx][next_by] == '#') {
							next_bx -= dx[dir];
							next_by -= dy[dir];
						}
						break;
					}
				}
				
				if(next_rx == next_bx && next_ry == next_by) {
					if(map[next_rx][next_ry]!='O') {
						int red_dist = Math.abs(next_rx-cur.rx)+Math.abs(next_ry-cur.ry);
						int blue_dist = Math.abs(next_bx-cur.bx)+Math.abs(next_by-cur.by);
						if(red_dist>blue_dist) {
							next_rx -= dx[dir];
							next_ry -= dy[dir];
						}
						else {
							next_bx -= dx[dir];
							next_by -= dy[dir];
						}
					}
				}
				
				if(visited [next_rx][next_ry][next_bx][next_by]==0) {
					visited [next_rx][next_ry][next_bx][next_by]=1;
					INFO next = new INFO();
					next.rx = next_rx;
					next.ry = next_ry;
					next.bx = next_bx;
					next.by = next_by;
					next.count = cur.count+1;
					q.add(next);
				}
			}
		}
		return ret;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		map = new char[10][11];
		
		for(int i = 0;i<n;i++) {
			String s = br.readLine();
			for(int j=0;j<m;j++) {
				map[i][j] = s.charAt(j);
				if(map[i][j]=='R') {
					start.rx = i; start.ry=j;
				}
				else if(map[i][j]=='B') {
					start.bx = i; start.by=j;
				}
			}
		}
		start.count = 0;
		
		int ret = bfs();
		System.out.println(ret);
		
	}
 }

