import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*백준 1158번 요세푸스 문제
  2020 / 02 / 05
 */

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		Queue<Integer> queue = new LinkedList<>();
		for(int i=1;i<=n;i++) {
			queue.add(i);
		}
		sb.append("<");
		while(queue.size()!=1) {
			for(int i=0;i<k-1;i++) {
				queue.add(queue.poll());
			}
			sb.append(queue.remove()+", ");
		}
		sb.append(queue.remove());
		sb.append(">");
		System.out.println(sb);
	}
}
