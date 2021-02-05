import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
/*백준 10799번 쇠막대기
  2020 / 02 / 05
 */

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = bf.readLine();
		int count = 1, result = 0;
		Stack<Integer> stack = new Stack<>();
		for(char ch: str.toCharArray()) {
			if(ch=='(') {
				stack.push(count++);
			}
			else if(ch == ')') {
				if(stack.peek()==count-1) {
					stack.pop();
					result+=stack.size();
				}
				else {
					stack.pop();
					result+=1;
				}
			}
		}
		bw.write(Integer.toString(result));
		bw.flush();
	}
 }
