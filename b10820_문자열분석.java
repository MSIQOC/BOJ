import java.io.*;
import java.util.*;
public class b10820_문자열분석 {
	public static void main(String [] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = "";
		while((s = br.readLine())!=null) { //EOF 처리
			//String s = br.readLine();
			int arr[] = new int[4];
			for(int i=0; i<s.length(); ++i) {
				char c = s.charAt(i);
				if(c>='A' && c<='Z')
					++arr[1];
				else if(c>='a' && c<='z')
					++arr[0];
				else if(c==' ')
					++arr[3];
				else
					++arr[2];
			}
			for(int i : arr) {
				bw.write(i+" ");
			}
			bw.write("\n");
			//s="";
		}
		bw.flush();
	}
}
