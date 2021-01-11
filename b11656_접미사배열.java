import java.io.*;
import java.util.*;
public class b11656_접미사배열 {
	public static void main(String []args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s = br.readLine();
		String arr[] = new String[s.length()];
		for(int i=0; i<s.length(); ++i) {
			String ss = "";
			for(int j=i; j<s.length(); ++j) {
				ss += s.charAt(j);
			}
			arr[i] = ss;
		}
		Arrays.sort(arr);
		for (String i : arr) {
			bw.write(i+"\n");
		}
		bw.flush();
	}
}
