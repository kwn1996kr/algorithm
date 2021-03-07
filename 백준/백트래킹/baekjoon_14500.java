import java.io.*;
import java.util.*;
/*	백준 14500번 테트로미노
 	2021 / 02 / 18
 */
public class Main {
	static int n,m,result;
	static int[][] arr;
	static boolean[][] check;
	static int dx[] = {0, 0, 1, -1};
    static int dy[] = {-1, 1, 0, 0}; 
    
    static void dfs(int x,int y,int sum,int length) {
    	if(length==4) {
    		result = Math.max(result, sum);
    		return;
    	}
    	
    	for(int i=0;i<4;i++) {
    		int nx = x + dx[i];
    		int ny = y + dy[i];
    		if(nx>=0 && nx<n && ny>=0 && ny<m) {
    			if(check[nx][ny]==false) {
    				check[nx][ny] = true;
    				dfs(nx,ny,sum+arr[nx][ny],length+1);
    				check[nx][ny] = false;
    			}
    		}
    	}
    }
    
    static void exception_shape(int x,int y) { //ㅏ 모양
    	int sum;
    	if(x>=0 && x+1<n && y>=0 && y+2<m){
    		sum = arr[x][y] + arr[x][y+1] + arr[x][y+2] + arr[x+1][y+1];
    		result = Math.max(result, sum);
    	}


    	if(x >= 0 && x+2 <n && y>=0 && y+1<m){
    		sum = arr[x][y] + arr[x+1][y] + arr[x+2][y] + arr[x+1][y+1];
    		result = Math.max(result, sum);
    	}


    	if(x-1 >= 0&& x <n && y >=0 && y+2 <m){
    		sum = arr[x][y] + arr[x][y+1] + arr[x][y+2] + arr[x-1][y+1];
    		result = Math.max(result, sum);
    	}

      
    	if(x-1 >= 0 && x+1 <n && y >=0 && y+1 <m){
    		sum = arr[x][y] + arr[x][y+1] + arr[x-1][y+1] + arr[x+1][y+1];
    		result = Math.max(result, sum);
    	}
    }
	public static void main(String[] args) throws Exception{		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		check = new boolean[n][m];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}		

		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				check[i][j] = true;
				dfs(i,j,arr[i][j],1);
				exception_shape(i,j);
				check[i][j] = false;
			}
		}
		
		System.out.println(result);
	}
 }

