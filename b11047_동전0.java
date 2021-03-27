//
//  Created by MinSeo on 2021/03/27.
//  Copyright ⓒ 2021 MinSeo Shin. All rights reserved.
//
import java.io.*;
import java.util.*;
public class b11047_µ¿Àü0 {
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int a[] = new int[n];
		for(int i=0; i<n; ++i) 
			a[i] = Integer.parseInt(br.readLine());
		int cnt=0;
		int j = n-1;
		while(k!=0) {
			if(k-a[j] >= 0) {
				k-=a[j];
				++cnt;
			}
			else {
				--j;
			}
		}
		bw.write(cnt+"\n");
		bw.flush();
	}
}
