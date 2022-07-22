package swea.D3.s5215_햄버거_다이어트;

import java.util.Scanner;

public class Solution5215Combination {
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			max = Integer.MIN_VALUE;
			int num = sc.nextInt(); // 재료 수
			int limit = sc.nextInt(); // 칼로리 제한
			int[][] foods = new int[2][num];
			
			
			for (int i = 0; i < num; i++) { // 재료의 정보 저장
				foods[0][i] = sc.nextInt(); // 맛
				foods[1][i] = sc.nextInt(); // 칼로리
			}

			for (int i = 1; i <= num; i++) {
				combination(foods, new int[2][num], 0, 0, limit);
			}

			System.out.printf("#%d %d\n", tc, max);

		}

		sc.close();

	}

	private static void combination(int[][] foods, int[][] sel, int idx, int k, int limit) {

		if (k == sel[0].length) {
			int taste = 0;
			int cal = 0;

			for (int i = 0; i < sel[0].length; i++) {
				taste += sel[0][i];
				cal += sel[1][i];
			}
			if (cal <= limit)
				max = max > taste ? max : taste;
				
			return;
		}
		

		for (int i = idx; i < foods[0].length; i++) { // 재료의 개수만큼
			sel[0][k] = foods[0][i];
			sel[1][k] = foods[1][i];
			combination(foods, sel, i + 1, k + 1, limit);
		}

	}

}
