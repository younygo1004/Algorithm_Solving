package ssafy.im.solve.s5215_햄버거_다이어트;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class 햄버거다이어트_부분집합 {
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
			//System.out.println(Arrays.toString(fact[3]));
			// solve
			
			powerSet(0,new boolean[N]);
			
			
			System.out.printf("#%d %d\n",tc, Ans);
		}
	}

	private static void powerSet(int idx, boolean[] sel) {
		if(idx==N) {
			//System.out.println(Arrays.toString(sel));
			// solving
			// 
			int calo = 0;
			int taste = 0;
			for (int i = 0; i < sel.length; i++) {
				if(sel[i]) {
					taste += fact[i][0];
					calo += fact[i][1];
				}
			}
			if(calo<=L) {
				//System.out.println(taste+":"+calo);
				Ans = Math.max(Ans, taste);
			}
			
			return;
		}
		
		sel[idx]=true;
		powerSet(idx+1, sel);
		sel[idx]=false;
		powerSet(idx+1, sel);
	}

}
