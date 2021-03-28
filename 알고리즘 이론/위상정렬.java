package org.practice.Main;
import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static ArrayList<Integer>[] list = new ArrayList[10];
	static int[] inDegree= new int[10];
	static void topologySort() {
		ArrayList<Integer> sortedList = new ArrayList<>();
		Queue<Integer> q = new LinkedList<>();
		
		//진입차수가 0인 노드를 큐에 삽입
		for(int i=1;i<=n;i++) {
			if(inDegree[i]==0) {
				q.add(i);
			}
		}
		
		//위상정렬이 완전히 수행되려면 정확히 n개의 노드를 방문해야된다.
		while(!q.isEmpty()) {
			int x = q.peek();
			q.remove();
			sortedList.add(x);
			
			for(int i=0;i<list[x].size();i++) {
				int getnode = list[x].get(i);
				
				inDegree[getnode]--;
				if(inDegree[getnode]==0) {
					q.add(getnode);
				}
			}
		}
		
		for(int i=0;i<sortedList.size();i++) {
			System.out.print(sortedList.get(i)+" ");
		}
	}
	public static void main(String[] args) throws Exception{
		n = 7;
		for(int i=1;i<=n;i++) {
			list[i] = new ArrayList<>();
		}
		list[1].add(2);
		inDegree[2]++;
		list[1].add(5);
		inDegree[5]++;
		list[2].add(3);
		inDegree[3]++;
		list[3].add(4);
		inDegree[4]++;
		list[4].add(6);
		inDegree[6]++;
		list[5].add(6);
		inDegree[6]++;
		list[6].add(7);
		inDegree[7]++;
		
		topologySort();
	}
 }
