import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
/*น้มุ 5430น๘ AC
  2020 / 02 / 03 
 */
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		
		while(n-->0) {
			boolean reverse = false;
			boolean error = false;
			StringBuilder sb = new StringBuilder();
			char[] cmd = bf.readLine().toCharArray();
			int num = Integer.parseInt(bf.readLine());
			String str = bf.readLine();
			str = str.substring(1,str.length()-1);
			StringTokenizer st = new StringTokenizer(str,",");
			ArrayList<Integer> list = new ArrayList<>();
			
			while(st.hasMoreTokens()) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			
			for(char c:cmd) {
				switch(c) {
					case 'R':
						if(reverse==false) {
							reverse= true;
						}
						else {
							reverse= false;
						}
					break;
					case 'D':
						if(list.size()==0) {
							error=true;
							break;
						}
						else {
							if(reverse==true) {
								list.remove(list.size()-1);
							}
							else {
								list.remove(0);
							}
						}
					break;
				}
			}
			if(error) {
				sb.append("error");
			}
			else {
				if(reverse==true) {
					sb.append("[");
					while(!list.isEmpty()) {
						sb.append(list.remove(list.size()-1));
						if(list.size()!=0) {
							sb.append(",");
						}
					}
					sb.append("]");
				}
				else {
					sb.append("[");
					while(!list.isEmpty()) {
						sb.append(list.remove(0));
						if(list.size()!=0) {
							sb.append(",");
						}
					}
					sb.append("]");
				}
			}
			System.out.println(sb);
		}
	}
}
