package swea.D3.s1234_비밀번호;


import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution1234 {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);


		for (int tc = 1; tc <= 10; tc++) {
			int N = sc.nextInt();
			String s = sc.next();
			int[] arr = new int[N+1];
			int cnt = 1;
			
			arr[cnt] = Integer.parseInt(s.substring(0, 1));
			
			for (int i = 1; i < s.length(); i++) {
				int cmp = Integer.parseInt(s.substring(i, i+1));
				
				if(arr[cnt] == cmp)
						cnt--;
				else
					arr[++cnt] = cmp;
	
			}
			
			
			System.out.printf("#%d ", tc);
			for (int i = 1; i <= cnt; i++) {
				System.out.printf("%d", arr[i]);
			}
			System.out.println();
			
			
		}
		
		
		sc.close();

	}

}