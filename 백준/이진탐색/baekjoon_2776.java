import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
/*백준 2776번 암기왕
2020 / 02 / 07
*/
public class Main {	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		while(n-->0) {
			StringBuilder sb = new StringBuilder();
			int one = Integer.parseInt(br.readLine());
			int[] arr = new int[one];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0;i<one;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			
			int two = Integer.parseInt(br.readLine());
			int[] brr = new int[two];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<two;i++) {
				brr[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i=0;i<two;i++) {
				if(Arrays.binarySearch(arr, brr[i]) >=0) {
					bw.write("1\n");
				}
				else {
					bw.write("0\n");
				}
			}
			bw.flush();
		}
	}
 }