package bj.silver1.s16926_배열_돌리기_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main16926 {
	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int cnt = Integer.parseInt(st.nextToken());
		arr = new int[N][M];

		for (int i = 0; i < arr.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < cnt; i++) {
			rotateArr(0, 0, arr.length, arr[0].length);
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.println(Arrays.toString(arr[i]).replaceAll("\\[|\\]|\\,", ""));

		}

	}

	private static void rotateArr(int sRow, int sCol, int eRow, int eCol) {
		
		 
		if (sRow == Math.min(arr.length, arr[0].length) / 2)
			return;

		rotateArr(sRow + 1, sCol + 1, eRow - 1, eCol - 1);

		int r = sRow;
		int c = sCol;
		int val = arr[sRow][sCol];

		for (int i = 0; i < dr.length; i++) {

			int start = Math.abs(sRow * dr[i]) + Math.abs(sCol * dc[i]) + 1;
			int end = Math.abs(dr[i] * eRow) + Math.abs(dc[i] * eCol);
			
			for (int j = start; j < end; j++) {
				r += dr[i];
				c += dc[i];

				int tmp = arr[r][c];
				arr[r][c] = val;
				val = tmp;

			}
		}

	}

}
