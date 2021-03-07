import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
/*백준 14729번 칠무해
2020 / 02 / 07
*/
public class Main {	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		
		double[] arr = new double[n];
		
		for(int i=0;i<n;i++) {
			arr[i]=Double.parseDouble(bf.readLine());
		}		
		
		Arrays.sort(arr);
		for(int i=0;i<7;i++) {
				System.out.printf("%.3f\n", arr[i]);
		}
	}
 }