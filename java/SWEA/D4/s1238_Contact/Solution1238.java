package swea.D4.s1238_Contact;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution1238 {
	
	static final int T = 10;
	static boolean[][] matrix;
	static int max;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer	st;
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int len = Integer.parseInt(st.nextToken());
			int vertex = Integer.parseInt(st.nextToken());
			
			matrix = new boolean[101][101];
			
			st = new StringTokenizer(br.readLine());
			
			while(st.hasMoreElements()) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				matrix[from][to] = true;
			}
			
			
			bfs(vertex);
			
			System.out.printf("#%d %d\n", tc, max);
			
			
		}
		
		br.close();
	}

	private static void bfs(int vertex) {
		Queue<Integer> queue = new LinkedList<Integer>();
		
		boolean[] isVisited = new boolean[101];
		isVisited[vertex] = true;
		queue.offer(vertex);
		max = Integer.MIN_VALUE;
		
		while (!queue.isEmpty()) {
			
			
			max = Integer.MIN_VALUE;
			
			int len = queue.size();
			
			for (int j = 0; j < len; j++) {
				Integer current = queue.poll();
				
				max = Math.max(max, current);
				
				for (int i = 0; i < matrix[current].length; i++) {
					if(!isVisited[i] && matrix[current][i]) {
						queue.offer(i);
						isVisited[i] = true;
					}
				}
			}
			
			
		}
		
	}

}
