
//5:45
import java.util.*;
import java.io.*;

public class b17413_�ܾ������2 {
	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Character> stack = new Stack<>();
		String s = sc.nextLine();
		int flip = 0;
		for (int j = 0; j < s.length(); ++j) {
			if (stack.empty() && s.charAt(j) == '<') {
				int k = j;
				while (s.charAt(k) != '>') {
					bw.write(s.charAt(k));
					++k;
				}
				bw.write('>');
				j = k;
			} 
			else if (s.charAt(j) == ' ') {
				while (!stack.empty())
					bw.write(stack.pop());
				bw.write(' ');
			} 
			else if(s.charAt(j) == '<') {
				while (!stack.empty())
					bw.write(stack.pop());
				--j;
			}
			else
				stack.push(s.charAt(j));
		}
		while (!stack.empty())
			bw.write(stack.pop());
		//bw.write("\n");
		bw.flush();
	}
}
