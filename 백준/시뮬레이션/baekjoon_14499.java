import java.io.*;
import java.util.*;
/*	����_14499��_�ֻ��� ������
 * 	2021/ 03/ 03
 */
public class Main {
	static int[] dice;
	static int[][] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		dice = new int[6]; //0�� ���� 1�� ���� 2�� ���� 3�� �Ʒ��� 4�� ���� 5�� ����
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<k;i++) {
			int dir = Integer.parseInt(st.nextToken());
			int temp;
			
			switch(dir) { //������ 1, ������ 2, ������ 3, ������ 4
				case 1 :
					if(y+1>=m) {
						continue;
					}
					y++;
					temp = dice[1];
					dice[1] = dice[4];
					dice[4] = dice[3];
					dice[3] = dice[5];
					dice[5] = temp;
					break;
				case 2 :
					if(y-1<0) {
						continue;
					}
					y--;
					temp = dice[1];
					dice[1] = dice[5];
					dice[5] = dice[3];
					dice[3] = dice[4];
					dice[4] = temp;
					break;
				case 3 :
					if(x-1<0) {
						continue;
					}
					x--;
					temp = dice[1];
					dice[1] = dice[2];
					dice[2] = dice[3];
					dice[3] = dice[0];
					dice[0] = temp;
					break;
				case 4 :
					if(x+1>=n) {
						continue;
					}
					x++;
					temp = dice[1];
					dice[1] = dice[0];
					dice[0] = dice[3];
					dice[3] = dice[2];
					dice[2] = temp;
					break;
			}
			
			if(arr[x][y]==0) {
				arr[x][y] = dice[3];
			}
			else {
				dice[3]=arr[x][y];
				arr[x][y] = 0;
			}
			
			System.out.println(dice[1]);
		}
	}
 }

