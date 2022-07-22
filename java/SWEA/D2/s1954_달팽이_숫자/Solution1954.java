package swea.D2.s1954_달팽이_숫자;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution1954 {
	
	public static void main(String[] args) throws FileNotFoundException {
//		System.setIn(new FileInputStream("E:\\SSAFY\\input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int[][] snail;
		
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			snail = new int[N][N];
			
			recurSnail(snail, 0, N, 1);
			
			
			System.out.println("#"+tc);
			
			for (int i = 0; i < snail.length; i++) {
				for (int j = 0; j < snail[i].length; j++) {
					System.out.print(snail[i][j]+ " ");
				}
				System.out.println();
			}
		}

		sc.close();
	}
	
	
	public static void recurSnail(int[][] arr, int start, int end, int value) {
		
		// start 0, end 5
		for (int i = start; i < end; i++) { // 왼쪽 > 오른쪽
			arr[start][i] = value++;
		}
		
		for (int i = start+1; i < end; i++) { // 위쪽 > 아래쪽
			arr[i][end-1] = value++;
		}
		
		for (int i = end-2; i >= start; i--) { // 오른쪽 > 왼쪽
			arr[end-1][i] = value++;
		}
		
		for (int i = end-2; i>start; i--) { // 아 > 위
			arr[i][start] = value++;
		}
		
		if(Math.pow(arr.length, 2) < value) {
			return;
		}
		
		recurSnail(arr, start+1, end-1, value);
		
		
		
		
		
	}
	
}
