package bj.silver3.s15649_NMs;

import java.util.Arrays;
import java.util.Scanner;

public class MainNM8 {

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[N];

		

		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		Arrays.sort(arr);
		
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
