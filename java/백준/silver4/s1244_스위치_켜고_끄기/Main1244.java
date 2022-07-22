
package bj.silver4.s1244_스위치_켜고_끄기;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main1244 {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);

		int st = sc.nextInt();
		int[] swch = new int[st + 1];
		int T;

		for (int i = 1; i < swch.length; i++) {
			swch[i] = sc.nextInt();
		}

		T = sc.nextInt();

		for (int i = 1; i <= T; i++) {
			int gen = sc.nextInt();
			int num = sc.nextInt();

			switch (gen) {
			case 1:
				for (int j = num; j < swch.length; j = j + num) {
					swch[j] = Math.abs(swch[j] - 1);

				}
				
				break;
			case 2:
				swch[num] = Math.abs(swch[num] - 1);

				int cnt = 1;

				while (true) {
					if (num - cnt < 1 || num + cnt > st)
						break;

					if (swch[num - cnt] == swch[num + cnt]) {
						swch[num - cnt] = Math.abs(swch[num - cnt] - 1);
						swch[num + cnt] = Math.abs(swch[num + cnt] - 1);

					} else
						break;

					cnt++;
				}

				break;

			default:
				break;
			}

		}

		for (int i = 1; i < swch.length; i++) {
			System.out.print(swch[i] + " ");
			if (i % 20 == 0)
				System.out.println();
		}

	}

}
