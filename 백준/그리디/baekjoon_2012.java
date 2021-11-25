import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
/*	백준_2012번_등수 매기기
 *  2021/ 11 / 18
 */
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long answer = 0;
        int[] arr = new int[n+1];
        int[] result = new int[n+1];
        for(int i=1;i<=n;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        for(int i=1;i<=n;i++){
            result[i] = Math.abs(arr[i]-i);
            answer+=result[i];
        }

        System.out.println(answer);
    }
}