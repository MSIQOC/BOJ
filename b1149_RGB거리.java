//
//  Created by MinSeo on 2021/03/27.
//  Copyright ⓒ 2021 MinSeo Shin. All rights reserved.
//
import java.io.*;
import java.util.*;
public class b1149_RGB°Å¸® {
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int D[][] = new int[n][3]; //dynamic
		int p[][] = new int[n][3]; //price
		for(int i=0; i<n; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; ++j) {
				p[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		D[0][0] = p[0][0];
		D[0][1] = p[0][1];
		D[0][2] = p[0][2];
		for(int i=1; i<n; ++i) {
			for(int j=0; j<3; ++j) {
				if(j==0) 
					D[i][j] = p[i][j] + Math.min(D[i-1][1], D[i-1][2]); 
				else if(j==1)
					D[i][j] = p[i][j] + Math.min(D[i-1][0], D[i-1][2]);
				else
					D[i][j] = p[i][j] + Math.min(D[i-1][0], D[i-1][1]);
			}
		}
		int ans = Integer.MAX_VALUE;
		for(int i=0; i<3; ++i) 
			if(D[n-1][i] < ans) ans = D[n-1][i];
		bw.write(ans+"\n");
		bw.flush();
	}
}
