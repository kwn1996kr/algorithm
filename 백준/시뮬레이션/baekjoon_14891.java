import java.util.*;
import java.io.*;
/*	백준_14891번_톱니바퀴
 *  2021/ 03/ 08
 */
public class Main {
	static int[][] arr = new int[4][8];
	static int[] rotate;
	
	static void move(int num,int dir) {
		rotate = new int[4];
		rotate[num-1] = dir;
		
		for(int i=num-1;i>=1;i--) {
			if(rotate[i]!=0 && arr[i][6]!=arr[i-1][2]) {
				rotate[i-1] = (rotate[i]==1) ? -1 : 1;
			}
		}
		
		for(int i=num-1;i<=2;i++) {
			if(rotate[i]!=0 && arr[i][2]!=arr[i+1][6]) {
				rotate[i+1] = (rotate[i]==1) ? -1 : 1;
			}
		}
		
		for(int i=0;i<4;i++) {
			if(rotate[i]==1) { // 시계방향
				int temp = arr[i][7];
				for(int j=6;j>=0;j--) {
					arr[i][j+1] = arr[i][j];
				}
				arr[i][0] = temp;
			}
			else if(rotate[i]==-1) { //반시계방향
				int temp = arr[i][0];
				for(int j=1;j<=7;j++) {
					arr[i][j-1] = arr[i][j];
				}
				arr[i][7] = temp;
			}
			else {
				continue;
			}
		}
	}
	static int count() {
		int result = 0;
		for(int i=0;i<4;i++) {
			if(arr[i][0]==0) {
				continue;
			}
			else if(i==0) {
				result+=1;
			}
			else if(i==1) {
				result+=2;
			}
			else if(i==2) {
				result+=4;
			}
			else{
				result+=8;
			}
		}
		return result;
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0;i<4;i++) {
			String s = br.readLine();
			for(int j=0;j<s.length();j++) {
				arr[i][j] = s.charAt(j)-'0';
			}
		}
		
		int k = Integer.parseInt(br.readLine());
		
		for(int i=0;i<k;i++) {		
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			move(num,dir);
		}
		
		System.out.println(count());
	}
}

