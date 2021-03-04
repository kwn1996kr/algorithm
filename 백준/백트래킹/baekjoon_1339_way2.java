import java.io.*;
import java.util.*;

/*백준 1339번 단어 수학
2020 / 02 / 09
*/
public class Main {	
	static String[] str;
	static boolean[] visit = new boolean [10];
	static int[] val;
	static int n,ans = Integer.MIN_VALUE;
	static List<Character> alphabet = new ArrayList<>();
	
	static void dfs(int depth) {
		if(depth == alphabet.size()) {
			int sum = 0;
			for(int i=0;i<n;i++) {
				int num=0;
				for(int j=0;j<str[i].length();j++) {
					num*=10;
					num+= val[alphabet.indexOf(str[i].charAt(j))];
				}
				sum+=num;
			}
			ans = Math.max(ans, sum);
			return;
		}
		for(int i=0;i<=9;i++) {
			if(visit[i]==false) {
				visit[i]=true;
				val[depth] = i;
				dfs(depth+1);
				visit[i] = false;
				val[depth] = 0;
			}
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		str = new String[n];
		
		for(int i=0;i<n;i++) {
			str[i] = br.readLine();
			for(int j=0;j<str[i].length();j++) {
				if(!alphabet.contains(str[i].charAt(j))) {
					alphabet.add(str[i].charAt(j));
				}
			}
		}
		
		val = new int[alphabet.size()];
		
		dfs(0);
		
		System.out.println(ans);
	}
 }