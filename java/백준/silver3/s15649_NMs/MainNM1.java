package bj.silver3.s15649_NMs;

import java.util.Scanner;

public class MainNM1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[N];
		boolean[] isSelected = new boolean[arr.length];
		
		sc.close();
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i+1;
		}
		
		permutation(arr, new int[M], 0, isSelected);
		
	}

	private static void permutation(int[] arr, int[] sel, int k, boolean[] isSelected) {
		
		if(k == sel.length) {
			for (int i = 0; i < sel.length; i++) {
				System.out.print(sel[i] + " ");
			}
			System.out.println();
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
