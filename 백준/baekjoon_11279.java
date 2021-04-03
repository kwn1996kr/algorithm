import java.io.*;
import java.util.*;
/*	백준_12738번_가장 긴 증가하는 부분 수열 3
 *  2021/ 04 / 02
 */
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
		for(int i=0;i<n;i++) {
			int temp = Integer.parseInt(br.readLine());
			if(temp==0) {
				if(q.size()==0) {
					sb.append(0+"\n");
				}
				else {
					sb.append(q.poll()+"\n");
				}
			}
			else {
				q.add(temp);
			}
		}
		System.out.println(sb);
	}
}
