import java.io.*;
import java.util.*;
public class b9012_��ȣ {
	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = sc.nextInt();
		sc.nextLine();
		while(t-->0) {
			int pandan=0; //no���� yes���� �Ǵ����ִ� ����.
			Stack<Integer> stack = new Stack<>();
			String s = sc.nextLine();
			for (int i=0; i<s.length(); ++i) {
				char c = s.charAt(i);
				if(c == '(')   //'('�� ������ �� ���ÿ� 1�� �������
					stack.push(1);
				else {
					if(stack.isEmpty()) { //')'�� ������ ���ÿ��� 1�� �����µ�, �� �� �������� ��Ȳ���� ������ ��������� no�� �Ǵ�.
						pandan=1;
						break;
					}
					else 
						stack.pop();  //')'�� ������ ���ÿ� ������ �� ������� ������ ���ÿ��� 1�� �ϳ� �����ش�.
				}
				
			}
			if(!stack.isEmpty() || pandan==1)  //������ ���µ��� ������ ������� �ʰų� pandan�� 1�� ������ no�� ���
				bw.write("NO\n");
			else  //�� ���� ��쿡�� yes�� ���.
				bw.write("YES\n");
			
		}
		bw.flush();
	}
}
