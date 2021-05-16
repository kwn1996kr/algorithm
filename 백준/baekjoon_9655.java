import java.io.*;
import java.util.*;

public class Main {
	static long n;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Long.parseLong(br.readLine());
		if(n%2==1) {
			System.out.println("SK");
		}
		else {
			System.out.println("CY");
		}
	}	
}