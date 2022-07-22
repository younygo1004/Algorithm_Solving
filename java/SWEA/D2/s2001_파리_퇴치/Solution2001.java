package swea.D2.s2001_파리_퇴치;
import java.util.Scanner;

public class Solution2001 {

	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int N, M;
		int flys[][];
		int max;
		int tmp;
		
		for (int i = 1; i <= T; i++) {
			N = sc.nextInt();
			M = sc.nextInt();
			
			max = Integer.MIN_VALUE;
			
			flys = new int[N][N];
			for (int j = 0; j < N; j++)
				for (int k = 0; k < N; k++)
					flys[j][k] = sc.nextInt();
			
			for (int j = 0; j <= N-M ; j++) {	
				for (int j2 = 0; j2 <= N-M ; j2++) {
					tmp = 0;
					for (int k = j; k < j+M; k++)
						for (int l = j2; l < j2+M; l++) 
							tmp += flys[k][l];
					
					if(max < tmp)
						max = tmp;
				}
				
			}
			
			System.out.printf("#%d %d\n", i, max);
		}
	}
}
