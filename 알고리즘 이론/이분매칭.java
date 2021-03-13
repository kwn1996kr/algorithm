package org.practice.Main;
import java.io.*;
import java.util.*;

public class Main {
	static int Max = 101;
	static ArrayList<Integer>[] list;
	static int[] d;
	static boolean[] c;
	static int n=3,m;
	
	//매칭에 성공한 경우 true, 실패한 경우 false
	static boolean dfs(int x) {
		//연결된 모든 노드에 대해서 들어갈 수 있는 시도
		for(int i=0;i<list[x].size();i++) {
			int t = list[x].get(i);
			//이미 처리한 노드는 더 이상 볼 필요가 없음
			if(c[t]) continue;
			c[t] = true;
			//비어있거나 점유 노드에 더 들어갈 공간이 있는 경우
			if(d[t]==0|| dfs(d[t])) {
				d[t] = x;
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) throws Exception{		
		list = new ArrayList[Max];
		d = new int [Max];
		c = new boolean[Max];
		
		for(int i=1;i<Max;i++) {
			list[i] = new ArrayList<>();
		}
		
		list[1].add(1);
		list[1].add(2);
		list[1].add(3);
		list[2].add(1);
		list[3].add(2);
		
		int count = 0;
		for(int i=1;i<=n;i++) {
			Arrays.fill(c, false);
			if(dfs(i)) count++;
		}
		System.out.printf("%d개의 매칭이 이루어졌습니다.\n",count);
		for(int i=1;i<Max;i++) {
			if(d[i]!=0) {
				System.out.print(d[i]+" -> "+i+"\n");
			}
		}
		
	}
 }
