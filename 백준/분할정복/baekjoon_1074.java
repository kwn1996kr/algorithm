import java.io.*;
import java.util.*;
/*	쿼트 트리 뒤집기
 *  2021/ 05 / 07
 */

public class Main {
	static int n,r,c,count=0;
	static void solve(int x,int y,int num) {
		if(x == r && y == c){
			System.out.println(count);
			return;
		}				
		
		if(r < x + num && r >= x && c < y + num && c >= y){ 
			solve(x,y,num/2);
			solve(x,y+num/2,num/2);
			solve(x+num/2,y,num/2);
			solve(x+num/2,y+num/2,num/2);
		}
		else {
			count += num*num;
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		int temp = (int) Math.pow(2, n);
		
		solve(0,0,temp);
	}	
}