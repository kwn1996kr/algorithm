import java.io.*;
/*백준 6588번 골드버그의 추측
  2020 / 02 / 05
 */

public class Main {
 	public static void main(String[] args) throws Exception {
 		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
 		StringBuilder sb = new StringBuilder();
 		boolean[] check = new boolean[1000001];
 		for(int i=2;i<1000001;i++){
 			if(check[i]==false) {
 				for(int j=i*2;j<1000001;j+=i) {
 					check[j] = true;
 				}
 			}
 		}
 		
 		while(true) {
 			int n = Integer.parseInt(bf.readLine());
 			boolean flag = false;
 			if(n==0) break;
 			for(int i=2;i<=n;i++) {
 				if(check[n-i]==false&&check[i]==false) {
 					flag = true;
 					sb.append(n+" = "+i+" + "+(n-i)+"\n");
 					break;
 				}
 			}
 			if(flag == false) {
 				sb.append("Goldbach's conjecture is wrong.\n");
 			}
 		}
 		System.out.println(sb);
 	}
}

