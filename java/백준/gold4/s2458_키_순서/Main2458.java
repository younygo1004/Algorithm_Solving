package bj.gold4.s2458_키_순서;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2458 {

	static final int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		

			int ans = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			int[][] adj = new int[V+1][V+1];
			
			for (int i = 0; i < adj.length; i++) {
				Arrays.fill(adj[i], INF);
			}
			
			
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int to = Integer.parseInt(st.nextToken());
				int from = Integer.parseInt(st.nextToken());
				adj[to][from] = 1;
			}
			
			for (int k = 1; k < adj.length; k++) {
				for (int i = 1; i < adj.length; i++) {
					for (int j = 1; j < adj.length; j++) {
						if(adj[i][k]!=INF&&adj[k][j]!=INF) {
							adj[i][j]=Math.min(adj[i][j], adj[i][k]+adj[k][j]);
						}
					}
				}
			}
			
			int cnt[] = new int[V+1];
			
			for (int i = 1; i < adj.length; i++) {
				for (int j = 1; j < adj.length; j++) {
					if(adj[i][j] != INF) {
						cnt[i]++;
						cnt[j]++;
					}
						
				}
			}
			
			for (int i = 1; i < cnt.length; i++) {
				if(cnt[i] == V-1) ans++;
			}
			
			System.out.println(ans);
			
		
		
		br.close();
		

	}
}
