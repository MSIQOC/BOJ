//5:45
import java.util.*;
import java.io.*;
public class b9093_단어뒤집기 {
	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = sc.nextInt();
		sc.nextLine();
		Stack<Character> stack = new Stack<>();
		for(int i=0 ;i<n; ++i) {
			String s = sc.nextLine();
			for(int j=0; j<s.length(); ++j) {
				if(s.charAt(j)==' ') {
					while(!stack.empty())
						bw.write(stack.pop());
					bw.write(' ');
				}
				else
					stack.push(s.charAt(j));
			}
			while(!stack.empty())
				bw.write(stack.pop());
			bw.write("\n");
		}
		bw.flush();
	}
}
