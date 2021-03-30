import java.io.*;
import java.util.*;
/*	백준_14003번_가장 긴 증가하는 부분 수열 5
 *	2021/ 03/ 27
 */
class Pair {
    int idx;
    int value;
 
    Pair(int idx, int value) {
        this.idx = idx;
        this.value = value;
    }
}
public class Main {
	static int[] arr;
	static int[] result;
	static Pair[] tracking;
	static int binary_search(int left,int right,int target) {
		int mid;
		while(left<right) {
			mid = (left+right)/2;		
			if(result[mid]<target) {
				left=mid+1;
			}
			else{
				right = mid;
			}
		}
		return right;
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		arr = new int[n];
		result = new int[n];
		tracking = new Pair[n];
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int index = 0;
		result[0]=arr[0];
		tracking[0] = new Pair(0,arr[0]);
		
		for(int i=1;i<n;i++) {
			if(arr[i]>result[index]) {
				result[++index] = arr[i];
				tracking[i] = new Pair(index,arr[i]);
			}
			else{
				int idx = binary_search(0,index,arr[i]);
				result[idx] = arr[i];
				tracking[i] = new Pair(idx,arr[i]);
			}
		}
		
		Stack<Integer> stack = new Stack<>();
		int temp = index;
		for(int i=n-1;i>=0;i--) {
			if(temp==tracking[i].idx) {
				stack.add(tracking[i].value);
				temp--;
			}
		}
		
		sb.append(stack.size()+"\n");
		while(!stack.isEmpty()) {
			sb.append(stack.pop()+" ");
		}
		
		System.out.println(sb);	
	}
 }
