import java.io.*;
import java.util.*;
public class b9012_괄호 {
	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = sc.nextInt();
		sc.nextLine();
		while(t-->0) {
			int pandan=0; //no인지 yes인지 판단해주는 변수.
			Stack<Integer> stack = new Stack<>();
			String s = sc.nextLine();
			for (int i=0; i<s.length(); ++i) {
				char c = s.charAt(i);
				if(c == '(')   //'('를 만났을 때 스택에 1을 집어넣음
					stack.push(1);
				else {
					if(stack.isEmpty()) { //')'일 때에는 스택에서 1을 꺼내는데, 이 때 꺼내야할 상황에서 스택이 비어있으면 no로 판단.
						pandan=1;
						break;
					}
					else 
						stack.pop();  //')'를 만남과 동시에 스택이 안 비어있을 때에는 스택에서 1을 하나 꺼내준다.
				}
				
			}
			if(!stack.isEmpty() || pandan==1)  //끝까지 갔는데도 스택이 비어있지 않거나 pandan이 1일 때에는 no를 출력
				bw.write("NO\n");
			else  //그 외의 경우에는 yes를 출력.
				bw.write("YES\n");
			
		}
		bw.flush();
	}
}
