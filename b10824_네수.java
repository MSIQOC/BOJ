import java.io.*;
import java.util.StringTokenizer;

public class b10824_네수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  //값읽기
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));  //값출력
		StringTokenizer st = new StringTokenizer(br.readLine());
		long n1 = Long.parseLong(st.nextToken());
		long n2 = Long.parseLong(st.nextToken());
		long n3 = Long.parseLong(st.nextToken());
		long n4 = Long.parseLong(st.nextToken());
		String n11 = Long.toString(n1);
		String n22 = Long.toString(n2);
		String n33 = Long.toString(n3);
		String n44 = Long.toString(n4);
		String n1and2 = n11.concat(n22);
		String n3and4 = n33.concat(n44);
		long n12 = Long.parseLong(n1and2);
		long n34 = Long.parseLong(n3and4);
		bw.write(n12+n34+"\n");
		bw.flush();
	}
	
}
