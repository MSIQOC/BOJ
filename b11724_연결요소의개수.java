//
//  Created by MinSeo on 2021/03/03.
//  Copyright ⓒ 2021 MinSeo Shin. All rights reserved.
//
import java.io.*;
import java.util.*;
public class b11724_연결요소의개수 {
	static boolean visit[];
	static int graph[][];
	static int count = 0;
	static int n;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static void bfs(int v) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(v);
		visit[v] = true;
		while(!q.isEmpty()) {
			int x = q.poll();
			for(int i=1; i<=n; ++i) {
				if(graph[x][i]==1 && visit[i] == false) {
					q.offer(i);
					visit[i] = true;
				}
			}
		}
	}
	static void dfs(int v) throws IOException {
		visit[v] = true;
		for(int i=1; i<n+1; ++i) {
			if(graph[v][i] == 1 && visit[i] == false)
				dfs(i);
		}
		
	}
	public static void main(String [] args) throws IOException {

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		graph = new int[n+1][n+1];
		visit = new boolean[n+1];
		for(int i=0; i<m; ++i) {
			StringTokenizer stt = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(stt.nextToken());
			int b = Integer.parseInt(stt.nextToken());
			graph[a][b] = 1;
			graph[b][a] = 1;
		}
		for(int i=1; i<n+1; ++i) {
			if(visit[i] == false) {
				bfs(i);
				++count;
			}
		}
		bw.write(count+"\n");
		bw.flush();
	}
}
