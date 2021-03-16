//
//  Created by MinSeo on 2021/03/16.
//  Copyright ⓒ 2021 MinSeo Shin. All rights reserved.
//
import java.io.*;
import java.util.*;

public class b14888_연산자끼워넣기 {
	static long number[];
	static int lego[]; // 연산자 순서
	static long min = 10000000003L;
	static long max = -10000000003L;
	static int n;

	static void calculate() {
		long ans = number[0];
		int go = 1;
		int i = 0;
		while(i != n-1) {
			if(lego[i] == 0)
				ans += number[go];
			else if(lego[i] == 1)
				ans -= number[go];
			else if(lego[i] == 2)
				ans *= number[go];
			else if(lego[i] == 3)
				ans /= number[go];
			++i;
			++go;
		}
		if (ans < min)
			min = ans;
		if (ans > max)
			max = ans;
	}

	static void recursion(int cnt, long howmany[]) {
		if (cnt == n - 1) {
			calculate();
			cnt = 0;
			return;
		}
		for (int i = 0; i < 4; ++i) {
			if (howmany[i] != 0) {
				--howmany[i];
				lego[cnt] = i;
				recursion(cnt + 1, howmany);
				++howmany[i];
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		long howmany[] = new long[4];
		number = new long[n];
		lego = new int[n - 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; ++i)
			number[i] = Long.parseLong(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; ++i)
			howmany[i] = Long.parseLong(st.nextToken());
		recursion(0, howmany);
		bw.write(max + "\n" + min + "\n");
		bw.flush();
	}
}
