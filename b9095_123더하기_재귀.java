import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class b9095_123´õÇÏ±â_Àç±Í {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int answer=0;
	static int n=0;
	static void gogo(int sum) {
		if(sum==n) { 
			++answer;
			return;
		}
		else if(sum>n)
			return;
		gogo(sum+1);
		gogo(sum+2);
		gogo(sum+3);
	}
	public static void main(String[] args) throws IOException {
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			n = Integer.parseInt(br.readLine());
			gogo(0);
			bw.write(answer+"\n");
			answer = 0;
		}
		bw.flush();
	}
}
