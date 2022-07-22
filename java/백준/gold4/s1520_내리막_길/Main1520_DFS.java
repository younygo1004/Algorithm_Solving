package bj.gold4.s1520_내리막_길;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1520_DFS {

	static int[][] map;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int ans;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		map = new int[M][N];

		for (int i = 0; i < map.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()); // map배열 초기화
				
			}
		}

//		dfs(0, 0, new boolean[M][N]);
		dfs(0, 0);

		System.out.println(ans);

		br.close();

	}


	private static void dfs(int row, int col) {

		if (row == map.length - 1 && col == map[0].length - 1) {
			ans++;
			return;
		}

		for (int i = 0; i < dr.length; i++) {

			int r = row + dr[i];
			int c = col + dc[i];

			if (r >= 0 && r < map.length && c >= 0 && c < map[0].length) {

				if (map[row][col] > map[r][c]) {
					dfs(r, c);
				}

			}

		}

	}

	private static void dfs(int row, int col, boolean[][] isVisted) { // 완탐(조건 X)

		if (row == map.length - 1 && col == map[0].length - 1) {
			ans++;
			return;
		}

		for (int i = 0; i < dr.length; i++) {

			int r = row + dr[i];
			int c = col + dc[i];

			if (r >= 0 && r < map.length && c >= 0 && c < map[0].length && !isVisted[r][c]) {
				isVisted[r][c] = true;
				dfs(r, c, isVisted);
				isVisted[r][c] = false;
			}

		}

	}

}
