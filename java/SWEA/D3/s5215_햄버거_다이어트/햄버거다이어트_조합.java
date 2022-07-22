package ssafy.im.solve.s5215_햄버거_다이어트;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class 햄버거다이어트_조합 {
	static int T,N,L, Ans=Integer.MIN_VALUE;
	static int[][] fact ;
	
	public static void main(String[] args) throws FileNotFoundException {
		
		
		System.setIn(new FileInputStream("햄버거다이어트.txt"));
		Scanner sc = new Scanner(System.in);
		T=sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			Ans = Integer.MIN_VALUE;
			N=sc.nextInt();
			L=sc.nextInt();
			fact = new int[N][2];
			for (int i = 0; i < N; i++) {
				fact[i][0]=sc.nextInt();
				fact[i][1]=sc.nextInt();
			}
			combination(0,0,0);
			System.out.printf("#%d %d\n",tc, Ans);
		}
	}

	private static void combination(int idx, int jSum, int cSum) {
		// 칼로리 넘어섰어요
		if(cSum > L) {
			return ;
		}
		// 더 고를게 없어요
		if(idx==N) {
			//System.out.println(jSum+":"+cSum);
			Ans = Math.max(Ans, jSum);
			return;
		}
		// 선택한 경우
		combination(idx+1, jSum + fact[idx][0], cSum + fact[idx][1]);
		// 안선택한 경우
		combination(idx+1, jSum, cSum);
	}

	

	

}
