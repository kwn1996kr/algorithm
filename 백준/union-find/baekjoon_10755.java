import java.io.*;
import java.util.*;
/*백준 10755번 공항
2021 / 02 / 15
*/
public class Main {
	static int getparent(int[] parent,int x) {
		if(parent[x]==x) return x;
		return parent[x] = getparent(parent,parent[x]);
	}
	
	static void unionparent(int[] parent, int x, int y) {
		x = getparent(parent,x);
		y = getparent(parent,y);
		if(x<y) parent[y]=x;
		else parent[x]=y;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int g = Integer.parseInt(br.readLine());
		int p = Integer.parseInt(br.readLine());
		int sum = 0;
		
		int[] parent = new int[g+1];
		for(int i=0;i<=g;i++) {
			parent[i] = i;
		}
		
		for(int i=0;i<p;i++){
			int temp = Integer.parseInt(br.readLine());
			int emptyGate = getparent(parent,temp);
			
			if(emptyGate==0) {
				break;
			}
			
			sum++;
			unionparent(parent,emptyGate,emptyGate-1);
		}
		
		System.out.println(sum);
		
	}
 }

