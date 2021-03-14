import java.io.*;
import java.util.*;
/*	백준_17140번_이차원 배열과 연산
 *  2021/ 03 / 14
 */
class Pair implements Comparable<Pair>{
	int num;
	int count;
	
	Pair(int num,int count){
		this.num = num;
		this.count = count;
	}
	
	public int compareTo(Pair o){
		if(this.count==o.count) {
			return this.num-o.num;
		}
		return this.count-o.count;
	}
}
public class Main {
	static int r,c,k;
	static int row=3, col=3;
	static int[][] arr = new int[101][101];
	static ArrayList<Pair> list;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		for(int i=1;i<=3;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=3;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		int time=0;
		while(true) {
			if(time==101) {
				time = -1;
				break;
			}
			if(row<=100 && col<=100) {	
				if(arr[r][c]==k) {
					break;
				}
			}
			
			if(row>=col) {
				for(int i=1;i<=row;i++) {
					int[] cnt = new int[101];
					for(int j=1;j<=col;j++) {
						if(arr[i][j]==0) continue;
						cnt[arr[i][j]]++;
						arr[i][j]=0;
					}
					list = new ArrayList<>();
					for(int j=1;j<cnt.length;j++) {
						if(cnt[j]!=0) {
							list.add(new Pair(j,cnt[j]));
						}
					}
					Collections.sort(list);
					int index = 1;
					for(Pair temp:list) {
						arr[i][index++] = temp.num;
						arr[i][index++] = temp.count;
					}
					if(col<=index) {
						col = index;
					}
				}
			}
			else {
				for(int i=1;i<=col;i++) {
					int[] cnt = new int[101];
					for(int j=1;j<=row;j++) {
						if(arr[j][i]==0) continue;
						cnt[arr[j][i]]++;
						arr[j][i]=0;
					}
					list = new ArrayList<>();
					for(int j=1;j<cnt.length;j++) {
						if(cnt[j]!=0) {
							list.add(new Pair(j,cnt[j]));
						}
					}
					Collections.sort(list);
					int index = 1;
					for(Pair temp:list) {
						arr[index++][i] = temp.num;
						arr[index++][i] = temp.count;
					}
					if(row<=index) {
						row = index;
					}
				}
			}
			time++;
		}
		
		System.out.println(time);
	}
}