import java.io.*;
import java.util.*;
public class b11655_ROT13 {
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		//char c = 'c';
		String ss = "";
		for(int i=0; i<s.length(); ++i) {
			char c =  s.charAt(i);
			//S
			if(c>='A' && c<='Z') {
				if(c+13 > 'Z') {
					//System.out.println("yesyes");
					int b = (char) 'A'+13-('Z'-c)-1;
					ss += (char) b;
				}
				else {
					int b = c+13;
					ss += (char) b;
				}
			}
			else if(c>='a' && c<='z') {
				if(c+13 >'z') {
					int b = (char)'a'+13-('z'-c)-1;
					ss += (char) b;
				}
				else {
					int b = c+13;
					ss += (char) b;
				}
			}
			else
				ss += c;
		}
		bw.write(ss);
		bw.flush();
	}
}
