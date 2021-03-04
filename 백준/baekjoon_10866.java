import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;
/*น้มุ 10866น๘ ตฆ 
  2020 / 02 / 03 
 */
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		StringBuilder sb = new StringBuilder();
		ArrayDeque<Integer> deque = new ArrayDeque<>();
		
		while(n-->0) {	
			StringTokenizer st = new StringTokenizer(bf.readLine());
			
			switch(st.nextToken()) {
				case "push_front":
					deque.addFirst(Integer.parseInt(st.nextToken()));
					break;
				case "push_back":
					deque.addLast(Integer.parseInt(st.nextToken()));
					break;
				case "pop_front":
					if(deque.isEmpty()) {
						sb.append(-1+"\n");
					}
					else {
						sb.append(deque.pollFirst()+"\n");
					}
					break;
				case "pop_back":
					if(deque.isEmpty()) {
						sb.append(-1+"\n");
					}
					else {
						sb.append(deque.pollLast()+"\n");
					}
					break;
				case "size":
					sb.append(deque.size()+"\n");
					break;
				case "empty":
					if(deque.isEmpty()) {
						sb.append(1+"\n");
					}
					else {
						sb.append(0+"\n");
					}
					break;
				case "front":
					if(deque.isEmpty()) {
						sb.append(-1+"\n");
					}
					else {
						sb.append(deque.peekFirst()+"\n");
					}
					break;
				case "back":
					if(deque.isEmpty()) {
						sb.append(-1+"\n");
					}
					else {
						sb.append(deque.peekLast()+"\n");
					}
					break;
			}
		}
		System.out.println(sb);
	}
}
