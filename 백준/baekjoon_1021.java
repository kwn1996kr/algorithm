import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
/*백준 10866번 회전하는 큐 
  2020 / 02 / 03 
 */
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		boolean flag = true;
		
		LinkedList<Integer> list = new LinkedList<>();
		int cnt = 0;
		for(int i=1;i<=n;i++) {
			list.add(i);
		}
		
		st = new StringTokenizer(bf.readLine());
		
		for(int i=0;i<m;i++) {	
			flag = true;
			int num = Integer.parseInt(st.nextToken());			
			
			while(flag) {
				if(list.get(0)==num) {
					flag = false;
				}
				else {
					if(list.indexOf(num)<=list.size()/2-1) {
						list.add(list.removeFirst());				
					}
					else {
						list.addFirst(list.removeLast());				
					}
					cnt++;
				}
			}
			list.remove();
		}
		System.out.println(cnt);
	}
}
