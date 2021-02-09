import java.io.*;
import java.util.StringTokenizer;
public class br11054_가장긴바이토닉부분수열 {
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int D[] = new int[n];
		int A[] = new int[n];
		int B[] = new int[n];
		for(int i=0; i<n; ++i) {
			D[i] = Integer.parseInt(st.nextToken());
			A[i] = 1;
			B[i] = 1;
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
		for(int i=n-1; i>=0; --i) {
			int mini = 0;
			for(int j=n-1; j>i; --j) {
				if(D[i] > D[j] && B[j] + 1 > mini) {
					mini = B[j];
					B[i] = mini+1;
				}
			}
		}
		int maxi = 0;
		for(int i=0; i<n; ++i) {
			if(A[i]+B[i]-1 > maxi) {
				maxi = A[i]+B[i]-1;
			}
		}
		bw.write((maxi)+"\n");
		bw.flush();
	}
}
