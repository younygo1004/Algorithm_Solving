package swea.D3.s9229_한빈이와_Spot_Mart;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import swea.SWEA;

public class Solution9229 {

	public static void main(String[] args) throws IOException {
		System.setIn(SWEA.f(9229));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			String[] strs = br.readLine().split(" ");
			int cnt = Integer.parseInt(strs[0]);
			int limit = Integer.parseInt(strs[1]);
			int ans = -1;
			
			strs = br.readLine().split(" ");
			
			for (int i = 0; i < strs.length; i++) {
				for (int j = i+1; j < strs.length; j++) {
					int tmp = Integer.parseInt(strs[i]) + Integer.parseInt(strs[j]);
					if(tmp > ans && tmp <=limit)
						ans = tmp;
				}
			}
			
			System.out.printf("#%d %d\n", tc, ans);
			
		}
		
		br.close();
	}

}
