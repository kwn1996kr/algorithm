import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
/*	백준_1038번_감소하는 수
 *  2021/ 11 / 18
 */
public class Main {
    static ArrayList<Long> list;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        list = new ArrayList<>();

        if(n < 10) System.out.println(n);
        else if(n > 1022) System.out.println("-1");
        else {
            for(int i = 0; i < 10; i++) {
                solution(i, 1);
            }
            Collections.sort(list);

            System.out.println(list.get(n));
        }
    }

    public static void solution(long num, int idx) {
        if(idx > 10) return;

        list.add(num);
        for(int i = 0; i < num % 10; i++) {
            solution((num * 10) + i, idx + 1);
        }
    }
}