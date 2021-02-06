import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*백준 2004번 조합 0의 개수
  2020 / 02 / 06
 */

public class Main {
 	public static void main(String[] args) throws Exception {
 		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
 		StringBuilder sb = new StringBuilder();
 		StringTokenizer st = new StringTokenizer(bf.readLine());
 		Long n = Long.parseLong(st.nextToken());
 		Long m = Long.parseLong(st.nextToken());
 		
 		long two = 0;
 		long five = 0;
 		
 		for(long i=2;i<=n;i*=2) {
 			two+=n/i;
 		}
 		for(long i=2;i<=m;i*=2) {
 			two-=m/i;
 		}
 		for(long i=2;i<=(n-m);i*=2) {
 			two-=(n-m)/i;
 		}
 		for(long i=5;i<=n;i*=5) {
 			five+=n/i;
 		}
 		for(long i=5;i<=m;i*=5) {
 			five-=m/i;
 		}
 		for(long i=5;i<=(n-m);i*=5) {
 			five-=(n-m)/i;
 		}
 		
 		sb.append(Math.min(two, five));
 		System.out.println(sb);
 	}
}

