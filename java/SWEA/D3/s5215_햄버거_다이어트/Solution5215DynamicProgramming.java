package swea.D3.s5215_햄버거_다이어트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution5215DynamicProgramming {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());

			int[] flavors = new int[N + 1];
			int[] calories = new int[N + 1];

			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				flavors[i] = Integer.parseInt(st.nextToken());
				calories[i] = Integer.parseInt(st.nextToken());

			}

			int[][] memo = new int[N + 1][W + 1];

			for (int i = 1; i <= N; i++) {
				for (int w = 0; w <= W; w++) {

					if (calories[i] <= w) {
						memo[i][w] = Math.max(memo[i - 1][w], flavors[i] + memo[i - 1][w - calories[i]]);
					} else {
						memo[i][w] = memo[i - 1][w];
					}

				}
			}

			System.out.printf("#%d %d\n", tc, memo[N][W]);
		}

		br.close();

	}

}
