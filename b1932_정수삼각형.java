//
//  Created by MinSeo on 2021/03/27.
//  Copyright ¨Ï 2021 MinSeo Shin. All rights reserved.
//
import java.io.*;
import java.util.*;
public class b1932_Á¤¼ö»ï°¢Çü {
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int pan[][] = new int[n][n];
		int D[][] = new int[n][n];
		for(int i=0; i<n; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<=i; ++j) 
				pan[i][j] = Integer.parseInt(st.nextToken());
		}
		D[0][0] = pan[0][0];
		for(int i=1; i<n; ++i) {
			for(int j=0; j<=i; ++j) {
				if(j-1<0) D[i][j] = pan[i][j] + D[i-1][j];
				else D[i][j] = pan[i][j] + Math.max(D[i-1][j-1], D[i-1][j]);		
			}
		}
		int ans=0;
		for(int i=0; i<n; ++i) {
			if(D[n-1][i] > ans) ans = D[n-1][i];
		}
		bw.write(ans+"\n");
		bw.flush();
	}
	
}
