import java.util.*;
import java.io.*;

public class b17413_�ܾ������2 {
	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Character> stack = new Stack<>();
		String s = sc.nextLine();
		for (int j = 0; j < s.length(); ++j) {
			if (stack.empty() && s.charAt(j) == '<') { //������ ����ְ� ���� ���ڰ� '<'�ΰ��
				int k = j;
				while (s.charAt(k) != '>') { //'>'�� ���� ������ ��� ����
					bw.write(s.charAt(k));
					++k;
				}
				bw.write('>');
				j = k;
			} 
			else if (s.charAt(j) == ' ') {  //���ÿ� ���̴ٰ� �����̽��� ������ ���ؿ� �ִ°� �� ������ ���⸦ �ϰԵ�.
				while (!stack.empty())
					bw.write(stack.pop());
				bw.write(' ');
			} 
			else if(s.charAt(j) == '<') { //���ÿ� ���̴ٰ� <�� ������ �Ǹ� �ִ°� �� ���س��� �ٽ� ù��° if���� �ɸ��� �ϱ� ���ؼ� j�� 1��ŭ ����.
				while (!stack.empty())
					bw.write(stack.pop());
				--j;	//�ٽ� ù��° if���� �ɸ��� �ϱ� ���ؼ� j ���� 1��ŭ ����.
			}
			else
				stack.push(s.charAt(j));  //���� ���׿� �� �ش��� �ȵǸ� �����������ϴ� �ܾ��̱� ������ ���ÿ� �ʾ���.
		}
		while (!stack.empty())
			bw.write(stack.pop());
		bw.flush();
	}
}
