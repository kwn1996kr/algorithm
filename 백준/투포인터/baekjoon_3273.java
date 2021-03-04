import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*백준 3273번 두 수의 합
2020 / 02 / 07
*/
public class Main {	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] arr= new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int goal = Integer.parseInt(br.readLine());
		int cnt = 0;
		int left = 0;
		int right = arr.length-1;
		Arrays.sort(arr);
		
		while(left<right) {
			if(goal>(arr[left]+arr[right])) {
				left++;
			}
			else if(goal==(arr[left]+arr[right])) {
				cnt++;
				left++;
			}
			else if(goal<(arr[left]+arr[right])){
				right--;
			}
		}
		
		System.out.println(cnt);
	}
 }