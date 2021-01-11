import java.io.*;
import java.util.*;
public class b2743_단어길이재기 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s = sc.nextLine();
		bw.write(s.length()+"\n");
		bw.flush();
	}
}
