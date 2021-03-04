import java.io.*;
import java.util.*;
/*백준 1406번 에디터
  2020 / 02 / 05
 */

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = bf.readLine();
		Stack<String> stack1 = new Stack<>();
		Stack<String> stack2 = new Stack<>();
		for(int i=0;i<str.length();i++) {
			stack1.add(str.substring(i,i+1));
		}
		int n = Integer.parseInt(bf.readLine());
		while(n-->0) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			switch(st.nextToken()) {
				case "L":
					if(stack1.isEmpty()) {
						continue;
					}
					else {
						stack2.add(stack1.pop());
					}
					break;
				case "D":
					if(stack2.isEmpty()) {
						continue;
					}
					else {
						stack1.add(stack2.pop());
					}
					break;
				case "B":
					if(stack1.isEmpty()) {
						continue;
					}
					else {
						stack1.pop();
					}
					break;
				case "P":
					stack1.add(st.nextToken());
					break;
			}
		}
		while(!stack1.isEmpty()) {
			stack2.add(stack1.pop());
		}
		while(!stack2.isEmpty()) {
			sb.append(stack2.pop());
		}
		System.out.println(sb);
	}
}
