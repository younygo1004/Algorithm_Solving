package swea.D4.s1251_하나로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution1251 {
	
	static class Island{
		long x;
		long y;
		
		public Island() {
		}
		
		public Island(long x, long y) {
			super();
			this.x = x;
			this.y = y;
		}
		
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			int V = Integer.parseInt(br.readLine());
			
			double[][] graph = new double[V][V];
			Island[] lands = new Island[V];
			boolean[] visited = new boolean[V];
			double[] distance = new double[V]; 
			double env = 0;
			
			for (int i = 0; i < V; i++) {
				lands[i] = new Island();
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < V; i++) {
				lands[i].x = Long.parseLong(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < V; i++) {
				lands[i].y = Long.parseLong(st.nextToken());
			}
			
			env = Double.parseDouble(br.readLine());
			
			for (int from = 0; from < lands.length; from++) {
				for (int to = from; to < lands.length; to++) {
					graph[from][to] = graph[to][from] = Math.pow(Math.abs(lands[from].x - lands[to].x), 2) + Math.pow(Math.abs(lands[from].y - lands[to].y), 2);
				}
			}
			
			Arrays.fill(distance, Double.MAX_VALUE);
			distance[0] = 0.0;
			
			for (int cnt = 0; cnt < V; cnt++) {
				
				double min = Double.MAX_VALUE;
				int idx = -1;
				
				for (int i = 0; i < V; i++) {
					if(!visited[i] && distance[i] < min) {
						min = distance[i];
						idx = i;
					}
				}
				
				visited[idx] = true;
				
				for (int i = 0; i < V; i++) {
					if(!visited[i] && graph[idx][i] != 0.0 && distance[i] > graph[idx][i]) {
						distance[i] = graph[idx][i];
					}
				}
				
			}
			
			double distSum = 0.0;
			for (int i = 0; i < distance.length; i++) {
				distSum += distance[i] * env;
			}
			
			System.out.printf("#%d %d\n", tc, Math.round(distSum));
			
			
			
		}
		
		
		br.close();
	}

}
