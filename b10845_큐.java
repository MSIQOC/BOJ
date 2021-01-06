import java.io.*;
import java.util.*;
public class b10845_ť {
	public static void main(String args[]) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int back = 0;
		int front = 0;
		int q[] = new int[10000];
		while(n-->0) {
			String s = sc.next();
			if(s.equals("push")) {
				int a = sc.nextInt();
				q[back] = a;
				++back;
			}
			else if(s.equals("pop")) {
				if(back-front==0) 
					bw.write("-1\n");
				else {
					bw.write(q[front]+"\n");
					++front;
				}
			}
			else if(s.equals("size")) {
				bw.write(back-front+"\n");
			}
			else if(s.equals("front")){
				if(back-front==0)
					bw.write("-1\n");
				else
					bw.write(q[front]+"\n");
			}
			else if(s.equals("back")) {
				if(back-front==0)
					bw.write("-1\n");
				else
					bw.write(q[back-1]+"\n");
			}
			else if(s.equals("empty")) {
				if(back-front==0)
					bw.write("1\n");
				else bw.write("0\n");
			}
				
		}
		bw.flush();
	}
}
