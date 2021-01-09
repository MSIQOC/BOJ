import java.io.*;
import java.util.*;
public class b9012_°ýÈ£ {
	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = sc.nextInt();
		sc.nextLine();
		
		while(t-->0) {
			int pandan=0;
			Stack<Integer> stack = new Stack<>();
			String s = sc.nextLine();
			for (int i=0; i<s.length(); ++i) {
				char c = s.charAt(i);
				if(c == '(')
					stack.push(1);
				else {
					if(stack.isEmpty()) {
						pandan=1;
						break;
					}
					else 
						stack.pop();
				}
				
			}
			if(!stack.isEmpty() || pandan==1)
				bw.write("NO\n");
			else
				bw.write("YES\n");
			
		}
		bw.flush();
	}
}
