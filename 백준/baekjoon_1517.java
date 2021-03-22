import java.io.*;
import java.util.*;
/*	백준_1517번_버블 소트
 *  2021/ 03 / 23
 */
public class Main {
	static int[] arr;
	static int count = 0;
	static void mergeSort(int left,int right) {
		if(left<right) {
			int mid = (left+right)/2;
			mergeSort(left,mid);
			mergeSort(mid+1,right);
			merge(left,right,mid);
		}
	}
	static void merge(int left,int right,int mid) {
		int[] copy = new int[arr.length];
		int i = left;
		int j = mid+1;
		int k = left;
		while(i<=mid && j<=right) {
			if(arr[i]<=arr[j]) {
				copy[k++] = arr[i++];
			}
			else {
				copy[k++] = arr[j++];
				count += (mid+1-i);
			}
		}
		while(i<=mid) {
			copy[k++] = arr[i++];
		}
		
		while(j<=right) {
			copy[k++] = arr[j++];
		}
		
		for(int l=left;l<=right;l++) {
			arr[l] = copy[l];
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		mergeSort(0,n-1);
		System.out.println(count);
	}
}