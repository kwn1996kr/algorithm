import java.io.*;
import java.util.*;

/*백준 13549번 숨바꼭질3
2020 / 02 / 10
*/
public class Main {	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] arr = new int[100001];
		boolean[] check = new boolean[100001];
		Queue<Integer> q = new LinkedList<>();
		Queue<Integer> next_queue = new LinkedList<>();
		q.add(n);
		check[n]=true;
		arr[n] = 0;

		while(!q.isEmpty()) {
			int temp = q.remove();

			if(temp*2<=100000&&check[temp*2]==false) {
				q.add(temp*2);
				check[temp*2]=true;
				arr[temp*2] = arr[temp];
			}
			
			if(temp+1<=100000&&check[temp+1]==false) {
				next_queue.add(temp+1);
				check[temp+1]=true;
				arr[temp+1]=arr[temp]+1;
			}
			
			if(temp-1>= 0 && check[temp-1]==false) {
				next_queue.add(temp-1);
				check[temp-1]=true;
				arr[temp-1]=arr[temp]+1;
			}
			
			if(q.isEmpty()) {
				q = next_queue;
				next_queue = new LinkedList<>();
			}
		}
		
		System.out.println(arr[k]);
	}
 }