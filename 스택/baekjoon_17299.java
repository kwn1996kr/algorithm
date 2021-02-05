import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
/*백준 17299번 오등큰수
  2020 / 02 / 05
 */

public class Main {
 	public static void main(String[] args) throws Exception {
 		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
 		int n = Integer.parseInt(bf.readLine());
 		StringBuilder sb = new StringBuilder();
 		int [] arr = new int[n];
 		int[] freq = new int[1000001];
 		Stack<Integer> stack = new Stack<>();
 		StringTokenizer st = new StringTokenizer(bf.readLine());
 		
 		for(int i=0;i<n;i++){
 			arr[i] = Integer.parseInt(st.nextToken());
 			freq[arr[i]]++;
 		}
 		
 		for(int i=0;i<n;i++) {
 			
 			while(!stack.isEmpty()&&freq[arr[stack.peek()]]<freq[arr[i]]) {
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

