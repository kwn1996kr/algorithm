package org.practice.Main;
import java.io.*;
import java.util.*;
public class Main {
	static int MAX = 100;
	static int INF = 1000000000;
	static int n = 6,result=0;
	static int[][] c = new int[MAX][MAX];
	static int[][] f = new int[MAX][MAX];
	static int[] d = new int[MAX]; // 방문 했는지 확인
	static ArrayList<Integer>[] a = new ArrayList[MAX];
	
	static void maxFlow(int start,int end) {
		while(true) {
			Arrays.fill(d, -1);
			Queue<Integer> q = new LinkedList<>();
			q.add(start);
			
			while(!q.isEmpty()) {
				int x = q.peek();
				q.remove();
				for(int i=0;i<a[x].size();i++) {
					int y = a[x].get(i);
					//방문하지 않고 용량이 남은 경우
					if(c[x][y]-f[x][y]>0 && d[y]==-1) {
						q.add(y);
						d[y] = x; //경로를 기억
						if(y==end) break;
					}
				}
			}
			if(d[end]==-1) break; //모든경로를 찾은 경우
			int flow = INF;
			for(int i = end; i!=start;i=d[i]) { //거꾸로 가면서 최소유량 탐색
				flow = Math.min(flow, c[d[i]][i]-f[d[i]][i]);
			}
			//최소유량만큼 추가 
			for(int i = end; i!=start;i=d[i]) { 
				f[d[i]][i]+=flow;
				f[i][d[i]] -=flow;
			}
			result += flow;
		}
	}
	public static void main(String[] args) throws Exception{
		
		for(int i = 1; i<MAX;i++) {
			a[i] = new ArrayList<>();
		}
		
		a[1].add(2);
		a[2].add(1);
		c[1][2] = 12;
		
		a[1].add(4);
		a[4].add(1);
		c[1][4] = 11;
		
		a[2].add(3);
		a[3].add(2);
		c[2][3] = 6;
		
		a[2].add(4);
		a[4].add(2);
		c[2][4] = 3;
		
		a[2].add(5);
		a[5].add(2);
		c[2][5] = 5;
		
		a[2].add(6);
		a[6].add(2);
		c[2][6] = 9;
		
		a[3].add(6);
		a[6].add(3);
		c[3][6] = 8;
		
		a[4].add(5);
		a[5].add(4);
		c[4][5] = 9;
		
		a[5].add(3);
		a[3].add(5);
		c[5][3] = 3;
		
		a[5].add(6);
		a[6].add(5);
		c[5][6] = 4;
		
		maxFlow(1,6);
		System.out.println(result);
	}
 }
