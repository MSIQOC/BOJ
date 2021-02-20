//
//  Created by MinSeo on 2021/02/20.
//  Copyright ⓒ 2021 MinSeo Shin. All rights reserved.
//
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class b9095_123더하기_재귀 {
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
		//기존에 더해준 것 뒤에 1을 더할 때
		gogo(sum+1);
		//재귀를 빠져나오면 sum+1에서 sum으로 나오게되고, sum에 다시 2를 더해준다.
		gogo(sum+2);
		//다시 재귀를 빠져나온 sum에 3을 더한다. sum이 n과 같거나 넘을 때 까지 반복.
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
