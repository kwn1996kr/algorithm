import java.io.*;
import java.util.*;
/* 백준_18808번_스티커 붙이기
   2021/  02  /26
 */

public class Main {
	static int n,m,k,r,c;
	static int[][] note;
	static int[][] sticker;
	static boolean is_possible(int x,int y) {		
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(note[x+i][y+j]==1&&sticker[i][j]==1) return false;
			}
		}
		
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(sticker[i][j]==1) {
					note[x+i][y+j]=1;
				}
			}
		}
		return true;
	}
	static void rotate(){
		int[][] tmp = new int[12][12];
		
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				tmp[i][j] = sticker[i][j];
			}
		}
		sticker = new int[12][12];
		
		for(int i=0;i<c;i++) {
			for(int j=0;j<r;j++) {
				sticker[i][j]=tmp[r-1-j][i];
			}
		}
		int temp = r;
		r =c;
		c =temp;

	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		note = new int[42][42];
		sticker = new int[12][12];
		
		while(k-->0) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			for(int i=0;i<r;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<c;j++) {
					sticker[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0;i<4;i++) {
				boolean flag = false;
				for(int j=0;j<=n-r;j++) {
					if(flag) break;
					for(int k=0;k<=m-c;k++) {
						if(is_possible(j,k)) {
							flag = true;
							break;
						}
					}
				}
				if(flag) break;
				rotate();
			}
		}
		
		int cnt=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				cnt += note[i][j];
			}
		}
		System.out.println(cnt);
	}
 }

