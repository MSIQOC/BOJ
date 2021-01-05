import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;
public class b10828_���� {
	static int size=0;
	static int stack[] = new int[10000];
	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n;
		n = sc.nextInt();  //n�� �Է¹ޱ�
		//sc.nextLine();  //sc�� ���۸� Ŭ�������ֱ� ���ؼ�
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));  //���б�
		for (int i=0; i<n; ++i) {
			String a = sc.next();
			if(a.equals("push")) {  //�ڹٿ��� ��Ʈ���� ���� �� �ּҰ� ������ ���� ������ == ��ſ� equals �޼ҵ带 ����Ѵ�.
				int m = Integer.parseInt(sc.next());
				//System.out.println("m:" + m);
				stack[size] = m;
				//System.out.println("stack:" + stack[size]);
				++size;
			}
			else if(a.equals("top")) {
				if(size==0) {
					bw.write("-1\n");
				}
				else{
					bw.write(stack[size-1]+"\n");
				}
			}
			else if(a.equals("pop")) {
				if(size==0) {
					bw.write("-1\n");
				}
				else {
					//System.out.println(stack[size-1]);
					bw.write(stack[size-1]+"\n");
					--size;
				}
			}
			else if(a.equals("size")) {
				bw.write(size+"\n");
			}
			else if(a.equals("empty")) {
				if(size==0)
					bw.write("1\n");
				else
					bw.write("0\n");
			}
			
		}
		bw.flush();
	}
}
