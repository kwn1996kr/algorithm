import java.io.*;
import java.util.*;

/*백준 10973번 이전 순열
2020 / 02 / 10
*/
public class Main {	
	static void swap(int[] arr,int i,int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	static boolean post_permutation(int[] arr) {
		int i = arr.length-1;
		while(i>0 && arr[i-1]<=arr[i]) {
			i--;
		}
		if(i<=0) {
			return false;
		}
		int j = arr.length-1;
		while(arr[j]>=arr[i-1]) {
			j--;
		}
		swap(arr,i-1,j);
		j = arr.length-1;
		while(i<j) {
			swap(arr,i,j);
			i++;
			j--;
		}
		return true;
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		if(post_permutation(arr)) {
			for(int i=0;i<n;i++) {
				System.out.print(arr[i]+" ");
			}
		}
		else {
			System.out.println(-1+"\n");
		}
		
	}
 }