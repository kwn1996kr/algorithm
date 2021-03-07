import java.io.*;
import java.util.*;
/*	백준 16928번 뱀과 사다리 게임
 	2021 / 02 / 19
 */
public class Main {
	static int[] go = new int[101];
	static int[] dice = new int [101]; 
	static Queue<Integer> q = new LinkedList<>();
	public static void main(String[] args) throws Exception{		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		while(n-->0) {
			st = new StringTokenizer(br.readLine());
			go[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
		}
		while(m-->0) {
			st = new StringTokenizer(br.readLine());
			go[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
		}
		
		q.add(1);
		
		while(!q.isEmpty()) {
			int x = q.poll();
			for(int i=1;i<=6;i++) {
				int next = x+i;
				if(x+i>100) {
					continue;
				}
				if(go[next]!=0) {
					next = go[next];
				}
				if(dice[next]==0) {
					dice[next] = dice[x]+1;
					q.add(next);
				}
			}
		}
		
		System.out.println(dice[100]);
	}
 }

