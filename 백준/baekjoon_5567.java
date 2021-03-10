import java.util.*;
import java.io.*;
/*	백준_5567번_결혼식
 *  2021/ 03/ 09
 */
public class Main {
	static int MAX = 500 + 1;  
	static ArrayList<Integer>[] list;
	static boolean[] friendList;
	static void findFriends(int num) {
		for(int i=0; i< list[num].size();i++) {
			int next =list[num].get(i);
			friendList[next]=true;
		}
		if(num==1)
            for (int i = 0; i < list[1].size(); i++)
            {
                    int next =list[1].get(i);
                    findFriends(next);
            }

	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		list = new ArrayList[MAX];
		friendList = new boolean[MAX];
		
		for(int i=1;i<MAX;i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=1;i<=m;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		findFriends(1);
		
		int cnt = 0;
		
		for(int i=2;i<=n;i++) {
			if(friendList[i]) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
}

