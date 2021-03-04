import java.io.*;
import java.util.*;
/*	백준_1786번_찾기
 * 	2021/ 03/ 03
 */
public class Main {
	static ArrayList<Integer> list = new ArrayList<>();
	static int cnt=0;
	static int[] makeTable(String pattern){
		int patternSize = pattern.length();
		int[] table = new int[patternSize];
		int j=0;
		for(int i=1;i<patternSize;i++) {
			while(j>0 && pattern.charAt(i)!=pattern.charAt(j)) {
				j=table[j-1];
			}
			if(pattern.charAt(i)==pattern.charAt(j)) {
				table[i] = ++j;
			}
		}
		return table;
	}
	
	static void kmp(String parent,String Pattern) {
		int[] table = makeTable(Pattern);
		int parentSize = parent.length();
		int PatternSize = Pattern.length();
		int j=0;
		for(int i=0;i<parentSize;i++) {
			while(j>0 && parent.charAt(i)!=Pattern.charAt(j)) {
				j=table[j-1];
			}
			if(parent.charAt(i)==Pattern.charAt(j)) {
				if(j==PatternSize-1) {
					cnt++;
					list.add(i-PatternSize+2);
					j=table[j];
				}else {
					j++;
				}
			}
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String parent = br.readLine();
		String pattern = br.readLine();
		kmp(parent,pattern);
		System.out.println(cnt);
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		
	}
 }

