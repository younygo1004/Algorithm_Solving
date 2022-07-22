package bj.silver3.s15649_NMs;

import java.util.Arrays;
import java.util.Scanner;

public class MainNM5 {

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
		
		permutation(arr, new int[M], 0, new boolean[arr.length]);
		System.out.println(sb);
		
	}

	private static void permutation(int[] arr, int[] sel, int k, boolean[] isSelected) {
		
		if(k == sel.length) {
			
			
			for (int i = 0; i < sel.length; i++) {
				sb.append(sel[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		
		for (int i = 0; i < arr.length; i++) {
			if(!isSelected[i]) {
				sel[k] = arr[i];
				isSelected[i] = true;
				permutation(arr, sel, k+1, isSelected);
				isSelected[i] = false;
			}
			
		}

		
	}

}
