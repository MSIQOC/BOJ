import java.util.*;
import java.io.*;

public class b17413_단어뒤집기2 {
	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Character> stack = new Stack<>();
		String s = sc.nextLine();
		for (int j = 0; j < s.length(); ++j) {
			if (stack.empty() && s.charAt(j) == '<') { //스택이 비어있고 현재 문자가 '<'인경우
				int k = j;
				while (s.charAt(k) != '>') { //'>'를 만날 때까지 출력 시작
					bw.write(s.charAt(k));
					++k;
				}
				bw.write('>');
				j = k;
			} 
			else if (s.charAt(j) == ' ') {  //스택에 쌓이다가 스페이스를 만나면 스텍에 있는거 다 꺼내고 띄어쓰기를 하게됨.
				while (!stack.empty())
					bw.write(stack.pop());
				bw.write(' ');
			} 
			else if(s.charAt(j) == '<') { //스택에 쌓이다가 <를 만나게 되면 있는걸 다 토해내고 다시 첫번째 if문에 걸리게 하기 위해서 j값 1만큼 빼줌.
				while (!stack.empty())
					bw.write(stack.pop());
				--j;	//다시 첫번째 if문에 걸리게 하기 위해서 j 값을 1만큼 빼줌.
			}
			else
				stack.push(s.charAt(j));  //위의 사항에 다 해당이 안되면 뒤집혀져야하는 단어이기 때문에 스택에 너어줌.
		}
		while (!stack.empty())
			bw.write(stack.pop());
		bw.flush();
	}
}
