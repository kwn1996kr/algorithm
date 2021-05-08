import java.io.*;
import java.util.*;
/*	게임판 덮기(BOARDCOVER)
 *  2021/ 05 / 04
 */

public class Main {
	static int c,h,w,cnt;
	static int[][] arr;
	static int[][][] block = {{{0,0},{1,0},{1,1} },
							{ {0,0},{0,1},{1,1} },
							{ {0,0},{0,1},{1,0} },
							{ {0,0},{1,0},{1,-1}}
	};
	
	static void dfs() {
		int x = -1;
		int y = -1;
		for(int i=0;i<h;i++) {
			for(int j=0;j<w;j++) {
				if(arr[i][j]==0) {
					x=i;
					y=j;
					break;
				}
			}
			if(x!=-1) { //x가 -1이 아니라는 건 빈칸이 있다는 뜻으로 멈춘다.
				break;
			}
		}
		if(x==-1) { //x가 -1이라는 빈칸이 존재하지 않는다는 말이다.
			cnt++;
			return;
		}
		
		for(int i=0;i<4;i++) {
			boolean check = true;
			for(int j=0;j<3;j++) {
				int nx = x + block[i][j][0];
				int ny = y + block[i][j][1];
				if(nx<0 || nx>=h || ny<0 || ny>=w) {
					check=false;
					continue;
				}
				if((arr[nx][ny]+=1)>1) {
					check = false;
				}
			}
			if(check==true) {
				dfs();
			}
			for(int j=0;j<3;j++) {
				int nx = x + block[i][j][0];
				int ny = y + block[i][j][1];
				if(nx<0 || nx>=h || ny<0 || ny>=w) {
					continue;
				}
				arr[nx][ny]-=1;
			}
		}	
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		c = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while(c-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			arr = new int [h][w];
			cnt = 0;
			int spacecnt=0;
			
			for(int i=0;i<h;i++) {
				String line = br.readLine();
				for(int j=0;j<w;j++) {
					if(line.charAt(j)=='#') {
						arr[i][j]=1;
					}
					else {
						arr[i][j]=0;
						spacecnt++;
					}
				}
			}
			if(spacecnt%3!=0) {
				sb.append("0\n");
				continue;
			}
			dfs();
			sb.append(cnt+"\n");
		}
		System.out.print(sb);
	}
}

