import java.io.*;
import java.util.*;
/* 백준_1924번_2007년
   2021/  02  /24
 */
public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int[] days = {0,31,28,31,30,31,30,31,31,30,31,30,31};
        String[] weeks = {"SUN","MON","TUE","WED","THU","FRI","SAT"};
        
        int answer;
        int sum = 0;
        for(int i=0;i<a;i++){
            sum+=days[i];
        }
        sum+=b;
        answer = sum%7;
		System.out.println(weeks[answer]);
	}
 }

