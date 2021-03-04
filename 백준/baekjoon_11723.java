import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
/*백준 11723번 집합
2020 / 02 / 07
*/
public class Main {	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int bit = 0;
		while(n-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num;
			switch(st.nextToken()) {
				case "add":
					num = Integer.parseInt(st.nextToken());
					bit |= (1 << (num-1)); 
					break;
				case "remove":
					num = Integer.parseInt(st.nextToken());
					bit &= ~(1<<(num-1));
					break;
				case "check":
					num = Integer.parseInt(st.nextToken());
					if((bit & (1<<(num-1)))!=0) {
						sb.append("1\n");
					}
					else {
						sb.append("0\n");
					}
					break;
				case "toggle":
					num = Integer.parseInt(st.nextToken());
					bit ^= (1<<num-1);
					break;
				case "all":
					bit = ~0;
					break;
				case "empty":
					bit &= 0;
					break;
			}
		}
		System.out.println(sb);
	}
 }