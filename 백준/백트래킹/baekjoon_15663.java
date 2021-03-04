import java.io.*;
import java.util.*;
/*백준 15663번 N과M(9)
2020 / 02 / 14
*/
public class Main {
	static boolean[] check;
	static int[] arr; 
	static LinkedHashSet<String> set = new LinkedHashSet<>();
	static int n;
	static int m;
	static void dfs(int depth,String str) {
		if(depth==m) {
			set.add(str);
			return;
		}
		for(int i=0;i<n;i++) {
			if(check[i]==false){
				check[i] = true;
				dfs(depth+1,str+arr[i]+" ");
				check[i] = false;
			}
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n];
		check = new boolean[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		dfs(0,"");
		StringBuilder sb = new StringBuilder();
		for(String temp: set) {
			sb.append(temp+"\n");
		}
		System.out.println(sb);
	}
 }