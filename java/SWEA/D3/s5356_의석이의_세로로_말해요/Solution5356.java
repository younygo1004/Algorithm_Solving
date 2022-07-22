package swea.D3.s5356_의석이의_세로로_말해요;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution5356 {
	
	static final int NUM = 5;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		String[] strs = new String[NUM];
		
		for (int tc = 1; tc <= T; tc++) {
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < strs.length; i++) {
				strs[i] = br.readLine();
				max = Math.max(max, strs[i].length());
			}
			
			System.out.printf("#%d ", tc);
			
			for (int i = 0; i < max; i++) {
				for (int j = 0; j < strs.length; j++) {
					if(i < strs[j].length())
						System.out.print(strs[j].substring(i, i+1));
				}
			}
			System.out.println();
			
		}
		
		br.close();
	}

}
