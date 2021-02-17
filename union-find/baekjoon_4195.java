import java.io.*;
import java.util.*;
/* 백준 4195번 친구 네트워크
 	2021 / 02 / 17
 */
public class Main {
	static int n, m;
	static int[] parent;
	static int[] network;
	static StringBuilder sb = new StringBuilder();;
	
	static int getparent(int x) {
		if(parent[x]==x) return x;
		return parent[x] = getparent(parent[x]);
	}
	
	static void unionparent(int x, int y) {
		x = getparent(x);
		y = getparent(y);
		if(x<y) {
			parent[y] = x;
			network[x] += network[y];
			sb.append(network[x]+"\n");
		}
		else if(x==y) {
			sb.append(network[x]+"\n");
		}
		else {
			parent[x] = y;
			network[y] += network[x];
			sb.append(network[y]+"\n");
		}
		
		
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());	
		
		while(n-->0) {
			m = Integer.parseInt(br.readLine());
			int idx = 1;
			parent = new int [m*2+1];
			network = new int [m*2+1]; 
			
			for(int i=1;i<m*2+1;i++) {
				parent[i]=i;
				network[i] = 1;
			}
			
			Map<String,Integer> map = new HashMap<>();
			for(int i=0;i<m;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String a = st.nextToken();
				String b = st.nextToken();
				
				if(!map.containsKey(a)) {
					map.put(a, idx++);
				}
				
				if(!map.containsKey(b)) {
					map.put(b, idx++);
				}
				
				unionparent(map.get(a),map.get(b));
			}
		}
		System.out.println(sb);
	}
 }

