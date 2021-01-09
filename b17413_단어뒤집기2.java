
//5:45
import java.util.*;
import java.io.*;

public class b17413_단어뒤집기2 {
	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Character> stack = new Stack<>();
		String s = sc.nextLine();
		int flip = 0;
		for (int j = 0; j < s.length(); ++j) {
			/*
			if(s.charAt(j)=='<')
				flip = 0;
			if(flip==0) {
				bw.write(s.charAt(j));
				if(s.charAt(j) == '>') flip = 1;
			}
			else {
				
			}
			*/
			if (stack.empty() && s.charAt(j) == '<') {
				int k = j;
				while (s.charAt(k) != '>') {
					bw.write(s.charAt(k));
					++k;
				}
				bw.write('>');
				j = k;
				//System.out.println("hi: "+s.charAt(j));
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
