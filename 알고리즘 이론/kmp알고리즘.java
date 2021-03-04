import java.io.*;
import java.util.*;

public class Main {
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
					System.out.println((i-PatternSize+2)+"번째에서 찾았습니다.");
					j=table[j];
				}else {
					j++;
				}
			}
		}
	}
	public static void main(String[] args) throws Exception{
		String parent = "ababacabacaabacaaba";
		String pattern ="abacaaba";
		kmp(parent,pattern);
		
	}
 }

