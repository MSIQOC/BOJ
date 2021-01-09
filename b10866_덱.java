import java.io.*;
import java.util.*;

public class b10866_�� {
	public static void main(String args[]) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int f = 9999, b = 10000;  //�� �� ���� ��ġ f�� �� ���� ���� ��ġ b. 10000�� 10001�� ��´�.
		int d[] = new int[20000];  //�� �տ� ���Ƿ� �߰��� 0��° �迭�� push_front �����̳� push_back ������ �迭�� �ִ�� �� ����̹Ƿ� 10000+10000+1 = 20001 ũ���� �迭 ����.
		sc.nextLine();
		while (n-- > 0) {
			String s = sc.next();
			if(s.equals("push_front")) {
				int a = sc.nextInt();
				d[f] = a;			
				--f;
			}
			else if(s.equals("push_back")) {
				int a = sc.nextInt();
				d[b] = a;
				++b;
			}
			else if(s.equals("pop_front")) {
				if(b-f-1 == 0)
					bw.write("-1\n");
				else {
					++f;
					bw.write(d[f]+"\n");
				}
			}
			else if(s.equals("pop_back")) {
				if(b-f-1==0)
					bw.write("-1\n");
				else {
					--b;
					bw.write(d[b] + "\n");
				}
			}
			else if(s.equals("size")) {
				bw.write(b-f-1+"\n");
			}
			else if(s.equals("empty")) {
				if (b-f-1==0)
					bw.write("1\n");
				else
					bw.write("0\n");
			}
			else if(s.equals("front")) {
				if (b-f-1==0)
					bw.write("-1\n");
				else
					bw.write(d[f+1]+"\n");
			}
			else if(s.equals("back")) {
				if (b-f-1==0)
					bw.write("-1\n");
				else
					bw.write(d[b-1]+"\n");
			}
		}
		bw.flush();
	}
}