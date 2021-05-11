import java.io.*;
import java.util.*;
/*	쿼트 트리 뒤집기
 *  2021/ 05 / 07
 */

public class Main {
	static int c,n;
	static int[] height;
	static int solve(int left,int right) {
		if(left==right) {
			return height[left];
		}
		int mid = (left+right)/2;
		int result = Math.max(solve(left,mid),solve(mid+1,right));
		
		int low = mid;
		int high = mid+1;
		int h = Math.min(height[mid], height[mid+1]);
		result = Math.max(result, 2*h);
		
		while(left<low || high < right) {
			if(high<right && (low == left || height[high+1] > height[low-1])) {
				high+=1;
				h = Math.min(h, height[high]);
			}
			else {
				low-=1;
				h = Math.min(h, height[low]);
			}
			result = Math.max(result, h*(high-low+1));
		}
		return result;		
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		c = Integer.parseInt(br.readLine());
		while(c-->0) {
			n = Integer.parseInt(br.readLine());
			height = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0;i<n;i++) {
				height[i] = Integer.parseInt(st.nextToken());
			}
			System.out.println(solve(0,n-1));
		}
	}
}