import java.io.*;
import java.util.*;
/*¹éÁØ 1780¹ø °ö¼À
  2020 / 02 / 04
 */

public class Main {
	static long calculate(long a,long b,long c) {
		if(b==0) {
			return 1;
		}
		else if(b==1) {
			return a;
		}
		else {
			long temp = calculate(a,b/2,c)%c;
			if(b%2==0) return (temp*temp)%c;
			else return (((temp*temp)%c)*a)%c;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		long c = Long.parseLong(st.nextToken());
		
		System.out.println(calculate(a,b,c));
	}
}
