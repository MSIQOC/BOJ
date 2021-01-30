import java.io.*;
import java.util.*;
public class b10808_¾ËÆÄºª°³¼ö {
	public static void main(String []args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int[]arr = new int[27];
		for(int i=0; i<s.length(); ++i) {
			char c = s.charAt(i);
			int cc = (int) c;
			++arr[cc-97];
		}
		for(int i=0; i<26; ++i)
			bw.write(arr[i] + " ");
		bw.flush();
		
	}
}
