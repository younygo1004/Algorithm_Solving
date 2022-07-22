package bj.silver2.s1260_DFS와_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1260 {
	
	static boolean[][] matrix;
	static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer	st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); 
		M = Integer.parseInt(st.nextToken());
		int vertex = Integer.parseInt(st.nextToken());
		
		matrix = new boolean[N+1][N+1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			matrix[from][to] = matrix[to][from] = true;
		}
		
		
		dfs(vertex, new boolean[N+1]);
		System.out.println();
		bfs(vertex);
		
		
		br.close();
		
	}
	
	private static void dfs(int vertex, boolean[] isVisited) {
		
		isVisited[vertex] = true;
		System.out.print(vertex + " ");
		
		for (int i = 0; i < matrix[vertex].length; i++) {
			if(!isVisited[i] && matrix[vertex][i]) {
				dfs(i,isVisited);
			}
			
		}
	}
	
	private static void bfs(int vertex) {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] isVisted = new boolean[N+1];
		
		queue.offer(vertex);
		isVisted[vertex] = true;
		
		while (!queue.isEmpty()) {
			
			Integer current = queue.poll();
			System.out.print(current + " ");
			for (int i = 0; i < matrix[current].length; i++) {
				if(!isVisted[i] && matrix[current][i]) {
					queue.offer(i);
					isVisted[i] = true;
				}
			}
			
		}
		System.out.println();
		
	}

}
