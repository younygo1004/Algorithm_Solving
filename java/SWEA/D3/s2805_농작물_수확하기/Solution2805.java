package swea.D3.s2805_농작물_수확하기;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import swea.SWEA;

public class Solution2805 {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(SWEA.f(2805));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int point = N / 2;
			int sum = 0;

			if (N == 1) {
				sum = sc.nextInt();
				System.out.printf("#%d %d\n", tc, sum);
				continue;
			}

			for (int i = 0; i < N; i++) {
				String s = sc.next();
				int idx = Math.abs(point - i);
				
				for (int j = idx; j <= N-1-idx ; j++) {
					sum += Integer.parseInt(s.substring(j, j + 1));
				}
			}

			System.out.printf("#%d %d\n", tc, sum);
		}

		sc.close();

	}

}
