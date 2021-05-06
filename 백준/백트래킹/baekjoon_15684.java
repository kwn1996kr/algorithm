import java.io.*;
import java.util.*;
/*	배준 15684번 사다리 조작
 *  2021/ 05 / 04
 */

public class Main {
	static int n,k,cnt=0;
	static boolean flag =false;
	static int[] history = new int [11];
	static void dfs(int sum,int level) {
		if(sum>n) {
			return;
		}
		if(sum==n) {
			cnt++;
			if(cnt==k) {
				for(int i=0;i<level-1;i++) {
					System.out.print(history[i]+"+");
				}
				System.out.println(history[level-1]);
				flag = true;
				return;
			}
		}
		for(int i=1;i<=3;i++) {
			history[level]=i;
			dfs(sum+i,level+1);
		}
		return;
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		dfs(0,0);
	    if (!flag) {
            System.out.println(-1);
        }

	}
}

