import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
/*	백준_2828번_사과 담기 게임
 *  2021/ 11 / 18
 */
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int j = Integer.parseInt(br.readLine());
        int sum = 0;
        int left = 0;
        int right = m-1;

        for(int i=0;i<j;i++){
            int apple = Integer.parseInt(br.readLine())-1;
            if(apple>right){
                sum += apple-right;
                right = apple;
                left = apple - (m-1);
            }
            else if(apple < left){
                sum += left-apple;
                left = apple;
                right = apple + (m-1);
            }
        }
        System.out.println(sum);
    }
}