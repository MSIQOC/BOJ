import java.io.*;
public class b17478_����Լ���������  {
	static void KyosunimTT(int n, String s) {
		System.out.print(s);
		System.out.println("\"����Լ��� ������?\"");
		if(n==0) {
			System.out.print(s);
			System.out.println("\"����Լ��� �ڱ� �ڽ��� ȣ���ϴ� �Լ����\"");
			System.out.print(s);
			System.out.println("��� �亯�Ͽ���.");
			return;
		}
		else {
			System.out.print(s);
			System.out.println("\"�� ����. �������� �� �� ����⿡ �̼��� ��� ������ ����� ������ �־���.");
			System.out.print(s);
			System.out.println("���� ������� ��� �� ���ο��� ������ ������ �߰�, ��� �����Ӱ� ����� �־���.");
			System.out.print(s);
			System.out.println("���� ���� ��κ� �ǾҴٰ� �ϳ�. �׷��� ��� ��, �� ���ο��� �� ���� ã�ƿͼ� ������.\"");
			KyosunimTT(n-1, s+"----");
		}
		System.out.print(s);
		System.out.println("��� �亯�Ͽ���.");
	}
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		System.out.println("��� �� ��ǻ�Ͱ��а� �л��� ������ �������� ã�ư� ������.");
		String s = "";
		
		KyosunimTT(n, s);
	}
}
