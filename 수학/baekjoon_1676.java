import java.io.*;
/*���� 1676�� ���丮�� 0�� ����
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

