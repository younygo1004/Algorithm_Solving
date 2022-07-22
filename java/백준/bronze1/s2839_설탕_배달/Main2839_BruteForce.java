package bj.bronze1.s2839_설탕_배달;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2839_BruteForce {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int kilo = Integer.parseInt(br.readLine());
		int ans = -1;

		for (int i = 0; i <= kilo / 3; i++) {
			for (int j = 0; j <= kilo - 3*i / 5; j++) {
				if(i * 3 + j*5 == kilo) {
					if(ans == -1)
						ans = i + j;
					else
						ans = Math.min(ans, i+j);
				}
			}
		}

		System.out.println(ans);

		br.close();

	}

}
