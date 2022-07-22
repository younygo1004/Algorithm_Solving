package swea.D3.s1228_암호문1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import swea.SWEA;

public class Solution1228 {
	static final int T = 10;

	public static void main(String[] args) throws IOException {
		System.setIn(SWEA.f(1228));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int tc = 1; tc <= T; tc++) {
			br.readLine();
			String[] strs = br.readLine().split(" ");
			List<Integer> lst = new LinkedList<Integer>();
			
			for (int i = 0; i < strs.length; i++) {
				lst.add(Integer.parseInt(strs[i]));
			}
			br.readLine();
			
			strs = br.readLine().split("I");
			for (int i = 1; i < strs.length; i++) {
				String[] addListElements = strs[i].trim().split(" ");
				
				int idx = Integer.parseInt(addListElements[0]);
				
				for (int j = 2; j < addListElements.length; j++) {
					lst.add(idx++, Integer.parseInt(addListElements[j]));
				}
				
			}
			System.out.printf("#%d ", tc);
			for (int i = 0; i < 10; i++) {
				System.out.printf("%d ", lst.get(i));
			}
			System.out.println();
			
			
			
		}
		br.close();

	}

}
