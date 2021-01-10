import java.io.*;
import java.util.*;
public class br10799_¼è¸·´ë±â {
	public static void main(String []args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		char prev = '(';
		int total = 0;
		int wen=0;
		for(int i=0; i<s.length(); ++i) {
			char c = s.charAt(i);
			if(c=='(')
				++wen;
			else {
				if(prev=='('){
					total += wen-1;
				}
				else 
					++total;
				--wen;
			}
			prev = c;
		}  
		System.out.println(total);
	}
}
