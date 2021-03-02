//
//  Created by MinSeo on 2021/03/03.
//  Copyright ¨Ï 2021 MinSeo Shin. All rights reserved.
//
import java.io.*;
import java.util.*;
public class b2178_¹Ì·ÎÅ½»ö {
	static boolean visit[][];
	static int graph[][];
	static int dist[][];
	static int count = 0;
	static int n;
	static int m;
	static int dx[] = {-1, 1, 0, 0};
	static int dy[] = {0, 0, -1, 1};
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static void bfs(int i, int j) {
		Queue<Integer> xx = new LinkedList<>();
		Queue<Integer> yy = new LinkedList<>();
		xx.offer(i);
		yy.offer(j);
		++dist[i][j];
		while(!xx.isEmpty()) {
			int jj = xx.poll();
			int ii = yy.poll();
			
			for(int k=0; k<4; ++k) {	
				int x = jj + dx[k];
				int y = ii + dy[k];
				if(x<0 || x>=m || y<0 || y>=n) continue;
				if(graph[y][x] == 1 && visit[y][x] == false) {
					xx.offer(x);
					yy.offer(y);
					visit[y][x] = true;
					dist[y][x] = dist[ii][jj] + 1;
				}
			}
		}
	}
	public static void main(String [] args) throws IOException {

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		graph = new int[n][m];
		dist = new int[n][m];
		visit = new boolean[n][m];
		for(int i=0; i<n; ++i) {
			String a = br.readLine();
			for(int j=0; j<m; ++j) {
				int b = Character.getNumericValue(a.charAt(j));
				graph[i][j] = b;
			}
		}
		bfs(0,0);
		bw.write(dist[n-1][m-1]+"\n");
		bw.flush();
	}
}
