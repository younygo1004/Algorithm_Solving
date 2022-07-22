package bj.silver1.s2961_도영이가_만든_맛있는_음식;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Taste {
	private int sour;
	private int bitter;

	public Taste(int sour, int bitter) {
		super();
		this.sour = sour;
		this.bitter = bitter;
	}

	public int getSour() {
		return sour;
	}

	public void setSour(int sour) {
		this.sour = sour;
	}

	public int getBitter() {
		return bitter;
	}

	public void setBitter(int bitter) {
		this.bitter = bitter;
	}

}

public class Main2961 {
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int count = Integer.parseInt(br.readLine());
		Taste[] info = new Taste[count];
		
		int sour, bitter;
		StringTokenizer	st;
		
		for (int i = 0; i < info.length; i++) {
			st = new StringTokenizer(br.readLine());
			sour = Integer.parseInt(st.nextToken());
			bitter = Integer.parseInt(st.nextToken());
			
			info[i] = new Taste(sour, bitter);
		}
		
		br.close();


		for (int i = 1; i <= info.length; i++) {
			combination(info, new int[i], 0, 0);
		}
		
		System.out.println(min);
		

	}

	private static void combination(Taste[] info, int[] sel, int idx, int k) {

		if (k == sel.length) {
			
			int gap;
			int sour = 1;
			int bitter = 0;

			for (int i = 0; i < sel.length; i++) {
				
				sour *= info[sel[i]].getSour();
				bitter += info[sel[i]].getBitter();
			}
			
			gap = Math.abs(sour - bitter);
			
			min = Math.min(min, gap);
			

			return;
		}

		for (int i = idx; i < info.length; i++) { // 재료의 개수만큼
			sel[k] = i;
			combination(info, sel, i + 1, k + 1);
		}

	}

}
