package swea.D4.s5643_키_순서;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution5643_Floyd {
	static final int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			int ans = 0;
			int V = Integer.parseInt(br.readLine());
			int E = Integer.parseInt(br.readLine());
			
			int[][] adj = new int[V+1][V+1];
			
			for (int i = 0; i < adj.length; i++) {
				Arrays.fill(adj[i], INF);
			}
			
			
			for (int i = 0; i < E; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
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
			
			System.out.printf("#%d %d\n", tc, ans);
			
		}
		
		
		br.close();
		

	}
}
