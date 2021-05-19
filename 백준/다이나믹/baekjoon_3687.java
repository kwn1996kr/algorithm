import java.io.*;
import java.util.*;
/*	백준_3687번_성냥개비
 *  2021 / 05 / 17
 */
public class Main {
	static int c,n;
	static long[] minDp;
	static String[] maxDp;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		c = Integer.parseInt(br.readLine());
		minDp = new long[101];
		maxDp = new String[101];
		
		Arrays.fill(minDp, Long.MAX_VALUE);
		minDp[2]=1;
		minDp[3]=7;
		minDp[4]=4;
		minDp[5]=2;
		minDp[6]=6;
		minDp[7]=8;
		//minDp[8]=10;
		
		String[] add = {"1","7","4","2","0","8"};
		
		for(int i=9;i<=100;i++) {
			for(int j=2;j<=7;j++) {
				String line = minDp[i-j] + add[j-2];
				minDp[i] = Math.min(Long.parseLong(line),minDp[i] );
			}
		}
		
		maxDp[2] = "1";
		
		for(int i=3;i<=100;i++) {
			String line = "";
			if(i%2==0) {
				int num = i/2;
				for(int j=0;j<num;j++) {
					line+="1";
				}
				maxDp[i] = line;
			}
			else {
				int num=i-3;
				line += "7";
				for(int j=0;j<num/2;j++) {
					line+="1";
				}
				maxDp[i] = line;
			}
		}
		
		while(c-->0) {
			n = Integer.parseInt(br.readLine());					
			sb.append(minDp[n]+" "+maxDp[n]+"\n");
		}
		System.out.println(sb);
	}
}