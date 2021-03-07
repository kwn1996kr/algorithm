import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;
/*백준 2529번 부등호
  2020 / 02 / 04
 */

public class Main {
	static char[] arr = new char[10];
	static boolean[] check = new boolean [10];
	static LinkedList<String> list = new LinkedList<>();
	static int n;	
	static boolean ck(int a,int b,char c) {
		if(c=='<') {
			if(a>b) return false;
		}
		else {
			if(a<b) return false;
		}
		return true;
	}
	
	static void dfs(int index,String num) {
		if(index == n+1) {
			list.add(num);
			return;
		}		
		for(int i=0;i<10;i++) {
			if(check[i]==true) {
				continue;
			}
			if(index==0 || ck(num.charAt(index-1)-'0',i,arr[index-1])) {
				check[i] = true;
				dfs(index+1,num+i);
				check[i]=false;
			}			
		}
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		for(int i=0;i<n;i++) {	
			arr[i] = st.nextToken().charAt(0);
		}
		
		dfs(0,"");
		//Collections.sort(list);
		
		System.out.println(list.get(list.size()-1));
		System.out.println(list.get(0));
	}
}
