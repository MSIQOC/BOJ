import java.io.*;
import java.util.*;
public class b17298_오큰수 {
	public static void main(String []args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  //값읽기
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		Stack<Integer> stack = new Stack<>();
		int n = Integer.parseInt(br.readLine());
		int a[] = new int[1000001];
		int ans[] = new int[1000001];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; ++i) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		stack.push(0);
		for(int i=1; i<n; ++i) {
			if(stack.empty())
				stack.push(i);
			while(!stack.empty() && a[i]>a[stack.peek()]) {
				ans[stack.pop()] = a[i];
			}
			stack.push(i);
		}
		if(!stack.empty()) {
			while(!stack.empty()) {
				ans[stack.pop()] = -1;
			}
		}
		for(int i=0; i<n; ++i)
			bw.write(ans[i] + " ");
		bw.flush();
	}
}
