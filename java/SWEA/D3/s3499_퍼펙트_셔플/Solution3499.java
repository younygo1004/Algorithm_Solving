package swea.D3.s3499_퍼펙트_셔플;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import swea.SWEA;

public class Solution3499 {

	public static void main(String[] args) throws IOException {
		System.setIn(SWEA.f(3499));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			int len = Integer.parseInt(br.readLine());
			
			String str = br.readLine();
			String[] cards = str.split(" ");
			
			int half = (int)Math.round(cards.length / 2.0);
			
			System.out.printf("#%d ",tc);
			
			for (int i = 0; i < half; i++) {
				
				System.out.print(cards[i] + " ");
				
				if(i + half < cards.length)
				System.out.print(cards[i+half] + " ");
				
			}
			System.out.println();
			
		}
		
		
	}

}
