import java.io.*;
public class b9095_123더하기 {
	public static void main(String []args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  //값읽기
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));  
		int n = Integer.parseInt(br.readLine());
		int D[] = new int[12];
		D[1] = 1;
		D[2] = 2;
		D[3] = 4;
		for(int i=4; i<=11; ++i) {
			D[i] = D[i-1]+D[i-2]+D[i-3];
		}
		while(n-->0) {
			int in = Integer.parseInt(br.readLine());
			bw.write(D[in]+"\n");
		}
		bw.flush();
	}
}
