package bj.silver1.s1992_쿼드트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1992 {
	static char[][] video;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		video = new char[N][N];

		for (int i = 0; i < video.length; i++) {
			video[i] = br.readLine().toCharArray();
		}

		StringBuilder st = getCompressedString(0, 0, N, N, N);

		System.out.println(st.toString());

		br.close();

	}

	private static StringBuilder getCompressedString(int startX, int startY, int endX, int endY, int n) {

		int flag = getStateArray(startX, startY, endX, endY, n);

		if (flag == 1) {
			return new StringBuilder("1");
		}
		if (flag == 0) {
			return new StringBuilder("0");
		}

		int half = n / 2;

		return new StringBuilder("(" + getCompressedString(startX, startY, startX + half, startY + half, half)
				+ getCompressedString(startX + half, startY, startX + half * 2, startY + half, half)
				+ getCompressedString(startX, startY + half, startX + half, startY + half * 2, half)
				+ getCompressedString(startX + half, startY + half, startX + half * 2, startY + half * 2, half) + ")");

	}

	private static int getStateArray(int startX, int startY, int endX, int endY, int n) {

		int sum = 0;

		for (int i = startY; i < endY; i++) {
			for (int j = startX; j < endX; j++) {
				sum += video[i][j] - '0';
			}
		}

		if (sum == Math.pow(n, 2))
			return 1;
		else if (sum == 0)
			return 0;

		return -1;
	}

}
