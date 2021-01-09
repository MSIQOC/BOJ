import java.io.*;
import java.util.*;

public class b10866_덱 {
	public static void main(String args[]) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int f = 9999, b = 10000;  //맨 앞 수의 위치 f와 맨 뒤의 수의 위치 b. 10000과 10001로 잡는다.
		int d[] = new int[20000];  //맨 앞에 임의로 추가한 0번째 배열과 push_front 만번이나 push_back 만번이 배열을 최대로 쓸 경우이므로 10000+10000+1 = 20001 크기의 배열 생성.
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