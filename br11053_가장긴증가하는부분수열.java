import java.io.*;
import java.util.StringTokenizer;
public class b11053_가장긴증가하는부분수열 {
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int D[] = new int[n];
		int A[] = new int[n];
		for(int i=0; i<n; ++i) {
			D[i] = Integer.parseInt(st.nextToken());
			A[i] = 1;
		}
		for(int i=1; i<n; ++i) {
			int maxi = 0;
			for(int j=0; j<i; ++j) {
				if(D[i] > D[j] && A[j] + 1 > maxi) {
					maxi = A[j];
					A[i] = maxi+1;
				}
			}
		}
		int maxi = 0;
		for(int i=0; i<n; ++i) {
			if(A[i] > maxi)
				maxi = A[i];
		}
		bw.write(maxi+"\n");
		bw.flush();
	}
}
