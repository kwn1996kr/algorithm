package org.practice.Main;
import java.io.*;
import java.util.*;

public class Main {
	static int Max = 101;
	static ArrayList<Integer>[] list;
	static int[] d;
	static boolean[] c;
	static int n=3,m;
	
	//��Ī�� ������ ��� true, ������ ��� false
	static boolean dfs(int x) {
		//����� ��� ��忡 ���ؼ� �� �� �ִ� �õ�
		for(int i=0;i<list[x].size();i++) {
			int t = list[x].get(i);
			//�̹� ó���� ���� �� �̻� �� �ʿ䰡 ����
			if(c[t]) continue;
			c[t] = true;
			//����ְų� ���� ��忡 �� �� ������ �ִ� ���
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
		System.out.printf("%d���� ��Ī�� �̷�������ϴ�.\n",count);
		for(int i=1;i<Max;i++) {
			if(d[i]!=0) {
				System.out.print(d[i]+" -> "+i+"\n");
			}
		}
		
	}
 }
