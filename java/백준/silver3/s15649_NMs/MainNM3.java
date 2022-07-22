package bj.silver3.s15649_NMs;

import java.util.Scanner;

public class MainNM3 {

	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[N];
		
		sc.close();
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i+1;
		}
		
		permutation(arr, new int[M], 0);
		System.out.println(sb);
		
	}

	private static void permutation(int[] arr, int[] sel, int k) {
		
		if(k == sel.length) {
			
			
			for (int i = 0; i < sel.length; i++) {
				sb.append(sel[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		
		for (int i = 0; i < arr.length; i++) {
				sel[k] = arr[i];
				permutation(arr, sel, k+1);
			
		}
		
		
	}

}
