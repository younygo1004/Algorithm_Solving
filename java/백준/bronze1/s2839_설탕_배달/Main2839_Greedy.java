package bj.bronze1.s2839_설탕_배달;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2839_Greedy {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int kilo = Integer.parseInt(br.readLine());

		int ans = -1;

		if (kilo % 5 == 0)
			ans = kilo / 5;
		else {
			int five;
			int three;
			for (int i = kilo/5; i >= 0; i--) {
				five = i;
				three = (kilo - five*5) / 3;
				
				if(five*5 + three*3 == kilo) {
					ans = five + three;
					break;
				}
				
			}
			
		}

		System.out.println(ans);

		br.close();

	}

}
