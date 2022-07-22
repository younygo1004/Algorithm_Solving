package swea.D4.s1861_정사각형_방;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import swea.SWEA;

public class Solution1861 {

	public static void main(String[] args) throws IOException {
		System.setIn(SWEA.f(1861));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int max = Integer.MIN_VALUE;
			int num = 1;
			int N = Integer.parseInt(br.readLine());
			int[][] room = new int[N + 1][N + 1];
			boolean[][] visited = new boolean[N + 1][N + 1];

			for (int i = 1; i < room.length; i++) {
				String[] strs = br.readLine().split(" ");
				for (int j = 1; j < room[i].length; j++) {
					room[i][j] = Integer.parseInt(strs[j - 1]);
				}
			}

			for (int i = 1; i < room.length; i++) {
				for (int j = 1; j < room[i].length; j++) {
					if (!visited[i][j]) {
						int count = recursiveRoom(room, visited, i, j, room[i][j]);
						if (count >= max) {
							if (count == max) {
								num = Math.min(num, room[i][j]);
							} else {
								num = room[i][j];
								max = count;
							}
						}
						
					}

				}
			}

			System.out.printf("#%d %d %d\n", tc, num, max);
		}

	}

	private static int recursiveRoom(int[][] room, boolean[][] visited, int r, int c, int cmp) {
		// 방이 없거나 +1인 숫자가 아니면
		if (r < 1 || r >= room.length || c < 1 || c >= room.length || room[r][c] - cmp > 1 || room[r][c] - cmp < 0) {

			return 0;
		}

		visited[r][c] = true;

		return 1 + recursiveRoom(room, visited, r - 1, c, room[r][c])
				+ recursiveRoom(room, visited, r, c - 1, room[r][c])
				+ recursiveRoom(room, visited, r + 1, c, room[r][c])
				+ recursiveRoom(room, visited, r, c + 1, room[r][c]);

	}

}
