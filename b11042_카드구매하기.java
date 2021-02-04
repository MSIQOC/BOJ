import java.io.*;
import java.util.StringTokenizer;
public class b11042_카드구매하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  //값읽기
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));  
		int n = Integer.parseInt(br.readLine());
		int P[] = new int[n+1];
		int D[] = new int[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; ++i)
			P[i] = Integer.parseInt(st.nextToken());
		D[1] = P[1];
		for(int i=2; i<=n; ++i) {
			int m = P[i];
			for(int j=1; j<=i; ++j) {
				m = Math.max(m, D[j]+P[i-j]);
			}
			D[i] = m;
		}
		bw.write(D[n]+"\n");
		bw.flush();
	}
}
