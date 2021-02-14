import java.io.*;
import java.util.*;
/*น้มุ 15665 Nฐ๚ M (11)
2020 / 02 / 14
*/
public class Main {
	static boolean[] check;
	static int[] arr; 
	static int[] num;
	static LinkedHashSet<String> set = new LinkedHashSet<>();
	static int n;
	static int m;
	static void dfs(int depth) {
		if(depth==m) {
			String str="";
			for(int i=0;i<m;i++) {
				str = str+num[i]+" ";
			}
			set.add(str);
			return;
		}
		for(int i=0;i<n;i++) {
			if(check[i]==false){
				num[depth] = arr[i];
				dfs(depth+1);
			}
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n];
		num = new int[m];
		check = new boolean[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		dfs(0);
		StringBuilder sb = new StringBuilder();
		for(String temp: set) {
			sb.append(temp+"\n");
		}
		System.out.println(sb);
	}
 }

