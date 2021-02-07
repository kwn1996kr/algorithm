import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/*백준 1202번 보석 도둑
2020 / 02 / 07
*/
class Pair{
	int weight;
	int value;
	
	Pair(int weight,int value){
		this.weight = weight;
		this.value = value;
	}
	
}
public class Main {	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		Pair[] arr = new Pair[n];
		Integer[] w = new Integer[k];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(bf.readLine());	
			int m = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			arr[i] = new Pair(m,v);
		}
		
		for(int i=0;i<k;i++) {
			w[i] = Integer.parseInt(bf.readLine());
		}
		
		Arrays.sort(arr,new Comparator<Pair>() {
			public int compare(Pair o1,Pair o2) {
				if(o1.weight==o2.weight) {
					return o2.value - o1.value;
				}
				return o1.weight - o2.weight;
			}
		});
		
		Arrays.sort(w);
		
		PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());;
		long ans = 0;
		
		for(int i=0, j=0; i<k; i++) {
			while(j<n && arr[j].weight <= w[i]) {
				q.offer(arr[j++].value);
			}
			
			if(!q.isEmpty()) {
				ans += q.poll();
			}
		}
		
		System.out.println(ans);
			
	}
 }