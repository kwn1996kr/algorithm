import java.io.*;
import java.util.*;

public class Main {
	static int findString(String parent,String pattern) {
		int parentSize = parent.length();
		int patternSize = pattern.length();
		for(int i=0;i<=parentSize-patternSize;i++) {
			boolean finded = true;
			for(int j=0;j<patternSize;j++) {
				if(parent.charAt(i+j) != pattern.charAt(j)) {
					finded = false;
					break;
				}
			}
			if(finded) {
				return i;
			}
		}
		return -1;
	}
	public static void main(String[] args) throws Exception{
		String parent = "Hello World";
		String pattern = "llo W";
		int result = findString(parent,pattern);
		if(result==-1) {
			System.out.println("찾을 수 없습니다.");
		}
		else {
			System.out.println(result+1+"번째에서 찾았습니다.");
		}
	}
 }

