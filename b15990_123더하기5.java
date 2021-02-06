import java.io.*;
import java.util.*;
public class b15990_123더하기5 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		long[][] D = new long[100001][4];
		long div = 1000000009;
		D[1][1] = 1;
		D[2][2] = 1;
		D[3][1] = 1;
		D[3][2] = 1;
		D[3][3] = 1;
		for(int i=4; i<=100000; ++i) {
			D[i][3] = (D[i-3][1]%div + D[i-3][2]%div)%div;
			D[i][2] = (D[i-2][1]%div + D[i-2][3]%div)%div;
			D[i][1] = (D[i-1][2]%div + D[i-1][3]%div)%div;
			
		}
		while(t-->0) {
			int n = Integer.parseInt(br.readLine());
			bw.write((D[n][1]%div + D[n][2]%div + D[n][3]%div)%div + "\n");
		}
		bw.flush();
	}
}
