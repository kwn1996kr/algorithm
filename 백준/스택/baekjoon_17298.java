import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
/*백준 17298번 오큰수
  2020 / 02 / 05
 */

public class Main {
 	public static void main(String[] args) throws Exception {
 		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
 		int n = Integer.parseInt(bf.readLine());
 		StringBuilder sb = new StringBuilder();
 		int [] arr = new int[n];
 		Stack<Integer> stack = new Stack<>();
 		StringTokenizer st = new StringTokenizer(bf.readLine());
 		
 		for(int i=0;i<n;i++){
 			arr[i] = Integer.parseInt(st.nextToken());
 		}
 		
 		for(int i=0;i<n;i++) {
 			
 			while(!stack.isEmpty()&&arr[stack.peek()]<arr[i]) {
 				arr[stack.pop()] = arr[i];
 			}
 			
 			stack.push(i);
 		}
 		
 		while(!stack.isEmpty()) {
 			arr[stack.pop()]=-1;
 		}
 		
 		for(int i=0;i<n;i++){
 			sb.append(arr[i]+" ");
 		}
 		
 		System.out.println(sb);
 	}
}

