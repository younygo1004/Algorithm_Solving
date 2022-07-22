package swea.D3.s5215_햄버거_다이어트;

import java.util.Scanner;

public class Solution5215PowerSet {
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

			powerSet(foods, new boolean[num], 0, limit);
			
			System.out.printf("#%d %d\n",tc, max);
			
			
		}
		
		sc.close();

	}

	private static void powerSet(int[][] foods, boolean[] isSelected, int k, int limit) {
		
		if(k==isSelected.length) {
			
			int taste = 0;
			int cal = 0;
			
			for (int i = 0; i < isSelected.length; i++) {
				if(isSelected[i]) {
					taste += foods[0][i];
					cal += foods[1][i];
				}
				
			}
			if(cal <= limit) 
				max = max > taste ? max : taste;
			
			
			return;
		}
		
		
		isSelected[k] = true;
		powerSet(foods, isSelected, k+1, limit);
		isSelected[k] = false;
		powerSet(foods, isSelected, k+1, limit);
		
		
	}

}
