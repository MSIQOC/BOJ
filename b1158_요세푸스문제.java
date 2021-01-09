import java.io.*;
import java.util.*;
public class b1158_요세푸스문제 {
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Scanner sc = new Scanner(System.in);
		Queue<Integer> q = new LinkedList<Integer>();
		int n = sc.nextInt();
		int k = sc.nextInt();
		for(int i=1; i<=n; ++i)
			q.offer(i);
		int num=1;
		System.out.print("<");
		while(!q.isEmpty()) {
			if(q.size() == 1) {
				int p = q.poll();
				System.out.print(p+">");
			}
			else if(num==k) {	
				int p = q.poll();
				System.out.print(p+", ");
				num = 1;
			}
			else {
				int p = q.poll();
				q.offer(p);
				++num;
			}
		}
	}
}
