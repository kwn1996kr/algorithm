import java.io.*;
import java.util.*;
/*	백준 6603번 로또
 	2021 / 02 / 18
 */
public class Main {
	static int n;
	static int[] S;
	static boolean[] visited;
	
	static void print_lotto(int index,int depth) {
		if(depth == 6) {
			for(int i=0;i<n;i++) {
				if(visited[i]==true) {
					System.out.print(S[i]+" ");
				}
			}
			System.out.println();
		}
		
		for(int i=index;i<n;i++) {
			visited[i] =true;
			print_lotto(i+1,depth+1);
			visited[i] = false;
		}
	}
	public static void main(String[] args) throws Exception{		
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
		 while(true) {
			 StringTokenizer st = new StringTokenizer(br.readLine());
			 n = Integer.parseInt(st.nextToken());
			 if(n==0) {
				 break;
			 }
			 
			 S = new int [n];
			 visited = new boolean [n];
			 for(int i=0;i<n;i++) {
				 S[i] = Integer.parseInt(st.nextToken());
			 }
			 
			 print_lotto(0,0);
			 System.out.println();
		 }
	}
 }

