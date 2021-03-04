import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
/*백준 1339번 단어 수학
2020 / 02 / 09
*/
public class Main {	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[26];
		
		for(int i=0;i<n;i++) {
			String str = br.readLine();
			for(int j=0;j<str.length();j++) {
				arr[str.charAt(j)-'A'] += (int)Math.pow(10, str.length()-1-j);
			}
		}
		Arrays.sort(arr);
		
		int ans = 0;
		int cnt = 9;
		for(int i=25;i>=0;i--) {
			if(arr[i]!=0) {
				ans+=arr[i]*cnt--;
			}
		}
		
		System.out.println(ans);
	}
 }