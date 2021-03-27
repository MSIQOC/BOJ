//
//  Created by MinSeo on 2021/03/27.
//  Copyright ⓒ 2021 MinSeo Shin. All rights reserved.
//
import java.io.*;
import java.util.*;
public class b9461_ÆÄµµ¹Ý¼ö¿­ {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		long p[] = new long[101];
		p[1] = 1;
		p[2] = 1;
		p[3] = 1;
		p[4] = 2;
		p[5] = 2;
		p[6] = 3;
		p[7] = 4;
		p[8] = 5;
		p[9] = 7;
		p[10] = 9; //ÃÊ±âÈ­
		for(int i=11; i<=100; ++i) {
			p[i] = p[i-1] + p[i-5];
		}
		while(t-- > 0) {
			int a = Integer.parseInt(br.readLine());
			bw.write(p[a] + "\n");
		}
		bw.flush();
	}
}
