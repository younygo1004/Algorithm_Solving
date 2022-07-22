package bj.silver2.s16935_배열_돌리기_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main16935 {
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int cnt = Integer.parseInt(st.nextToken());

		int type;

		arr = new int[N][M];

		for (int i = 0; i < arr.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < cnt; i++) {
			type = Integer.parseInt(st.nextToken());

			int[] dr;
			int[] dc;
			int tmp[][] = new int[arr.length][arr[0].length]; // 임시 배열
			if (type == 3 || type == 4) // 배열을 회전시켜야 한다면
				tmp = new int[arr[0].length][arr.length];

			int rowHalf = arr.length / 2;
			int colHalf = arr[0].length / 2;

			switch (type) {
			case 1:

				for (int j = 0; j < rowHalf; j++) {
					swap(j, arr.length - j - 1);
				}

				break;
			case 2:
				for (int j = 0; j < arr.length; j++) {
					for (int k = 0; k < colHalf; k++) {
						swap(j, k, j, arr[j].length - k - 1);
					}
				}

				break;
			case 3:
				for (int j = 0; j < arr.length; j++) {
					for (int k = 0; k < arr[j].length; k++) {
						tmp[k][tmp[0].length - j - 1] = arr[j][k];
					}
				}
				arr = tmp;

				break;
			case 4:
				for (int j = 0; j < arr.length; j++) {
					for (int k = 0; k < arr[j].length; k++) {
						tmp[tmp.length - k - 1][j] = arr[j][k];
					}
				}
				arr = tmp;

				break;
			case 5:
				dr = new int[] { 0, 0, 1, 1 };
				dc = new int[] { 0, 1, 1, 0 };

				for (int j = 0; j < dr.length; j++) {
					int r = dr[j] * rowHalf;
					int c = dc[j] * colHalf;
					int r1 = dr[(j + 1) % dr.length] * rowHalf - r;
					int c1 = dc[(j + 1) % dc.length] * colHalf - c;
					
					
					for (int k = r; k < rowHalf + r; k++) {
						for (int l = c; l < colHalf + c; l++) {
							tmp[r1+k][c1+l] = arr[k][l];
						}
					}
				}
				arr = tmp;

				break;
			case 6:
				dr = new int[] { 0, 1, 1, 0 };
				dc = new int[] { 0, 0, 1, 1 };

				for (int j = 0; j < dr.length; j++) {
					int r = dr[j] * rowHalf;
					int c = dc[j] * colHalf;
					int r1 = dr[(j + 1) % dr.length] * (rowHalf) - r;
					int c1 = dc[(j + 1) % dc.length] * (colHalf) - c;
					
					
					for (int k = r; k < rowHalf + r; k++) {
						
						for (int l = c; l < colHalf + c; l++) {
							tmp[r1+k][c1+l] = arr[k][l];
						}
					}
				}
				arr = tmp;

				break;

			default:
				break;
			}
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.println(Arrays.toString(arr[i]).replaceAll("\\[|\\]|,", ""));

		}

	}

	private static void swap(int i, int i1) {
		int[] tmp = arr[i];
		arr[i] = arr[i1];
		arr[i1] = tmp;
	}

	private static void swap(int i, int j, int i1, int j1) {

		int tmp = arr[i][j];
		arr[i][j] = arr[i1][j1];
		arr[i1][j1] = tmp;

	}

}
