package swea.D4.s1223_계산기2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1223 {
	final static int T = 10;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int tc = 1; tc <= T; tc++) {
			br.readLine();
			
			StringTokenizer st = new StringTokenizer(br.readLine(), "+");
			int sum = 0;
			while(st.hasMoreElements()) {
				String s = st.nextToken();
				
				if(s.contains("*")) {
					
					StringTokenizer st2 = new StringTokenizer(s, "*");
					int tmp = 1;
					
					while(st2.hasMoreElements()) {
						tmp *= Integer.parseInt(st2.nextToken());
					}
					
					sum += tmp;
					
				}
				else
					sum += Integer.parseInt(s);
				
			}
			
			System.out.printf("#%d %d\n", tc, sum);
			
		}
		

	}

}
