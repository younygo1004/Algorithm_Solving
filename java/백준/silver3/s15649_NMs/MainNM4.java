package bj.silver3.s15649_NMs;

import java.util.Arrays;
import java.util.Scanner;

public class MainNM4 {

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[N];

		sc.close();

		for (int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
		}

		combination(arr, new int[M], 0, 0);
		System.out.println(sb);

	}

	private static void combination(int[] arr, int[] sel, int idx, int k) {

		if (k == sel.length) {
			for (int i = 0; i < sel.length; i++) {
				System.out.print(sel[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = idx; i < arr.length; i++) {
			sel[k] = arr[i];
			combination(arr, sel, i, k + 1);
		}

	}

}
