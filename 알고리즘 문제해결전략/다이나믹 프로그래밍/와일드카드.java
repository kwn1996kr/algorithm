import java.io.*;
import java.util.*;
/*	와일드 카드
 *  2021/ 05/ 07
 */

public class Main {
	static int c,n;
	static String W,S;
	static ArrayList<String> ans;
	static int[][] check;
	static int solve(int w,int s) {
		if(check[w][s]!=-1) {
			return check[w][s];
		}
		if(w<W.length() && s<S.length()) {
			if(W.charAt(w)=='?' || W.charAt(w)==S.charAt(s)) {
				return check[w][s] = solve(w+1,s+1);
			}
		}
		
		if(w == W.length()) {
			if(s== S.length()) {
				return check[w][s] = 1;
			}
			else {
				return check[w][s] = 0;
			}
		}
		
		if(W.charAt(w) == '*') {
			if(solve(w+1,s) == 1 || (s<S.length() && (solve(w,s+1) == 1)))
				return check[w][s] = 1;
		}

		
		return check[w][s]=0;
	}
	
	static void init() {
		for(int i=0;i<101;i++) {
			Arrays.fill(check[i], -1);
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		c = Integer.parseInt(br.readLine());
		while(c-->0) {
			W = br.readLine();
			n = Integer.parseInt(br.readLine());
			ans = new ArrayList<>();
			check = new int[101][101];
			
			for(int i=0;i<n;i++) {
				S = br.readLine().trim();
				init();
				if(solve(0,0)==1) {
					ans.add(S);
				}
			}
			
			Collections.sort(ans);
			
			for(int i=0;i<ans.size();i++) {
				//sb.append(ans.get(i)+"\n");
				System.out.println(ans.get(i));
			}
		}
		//System.out.println(sb);
	}	
}