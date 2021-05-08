import java.io.*;
import java.util.*;
/*	쿼트 트리 뒤집기
 *  2021/ 05 / 07
 */

public class Main {
	static int c,pointer;
	static String line;
	static String solve() {
		if(line.charAt(pointer)!='x') {
			return ""+line.charAt(pointer++);
		}
		pointer++;
		String one = solve();
        String two = solve();
        String three = solve();
        String four = solve();
        return 'x' + three + four + one + two;
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		c = Integer.parseInt(br.readLine());
		while(c-->0) {
			line = br.readLine();
			pointer = 0;
			System.out.println(solve());
		}
	}
}