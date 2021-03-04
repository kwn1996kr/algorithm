import java.io.*;
/*백준 1676번 팩토리얼 0의 개수
  2020 / 02 / 06
 */

public class Main {
 	public static void main(String[] args) throws Exception {
 		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
 		StringBuilder sb = new StringBuilder();
 		int n = Integer.parseInt(bf.readLine());
 		
 		int result = 0;
 		if(n>5) {
 			result += n/5;
 		}
 		if(n>25) {
 			result += n/25;
 		}
 		if(n>125) {
 			result += n/125;
 		}
 		
 		sb.append(result);
 		System.out.println(sb);
 	}
}

