import java.io.*;
import java.util.*;
public class b2609_최대공약수와최소공배수 {
	public static void main(String []args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n1 = Integer.parseInt(st.nextToken());
		int n2 = Integer.parseInt(st.nextToken());
		int G = 1, L = 1;
		int start = (n1 <= n2 ? n1: n2); //더 작은 수 넣기
		for(int i=start; i>0; --i) {
			if(n1%i == 0 && n2%i == 0) {
				G=i;
				break;
			}
		}
		int nn1 = n1/G, nn2 = n2/G;
		L = G*nn1*nn2;
		bw.write(G + "\n" + L);
		bw.flush();
	}
}
