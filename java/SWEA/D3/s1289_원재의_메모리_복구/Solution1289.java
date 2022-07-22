package swea.D3.s1289_원재의_메모리_복구;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import swea.SWEA;

public class Solution1289 {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(SWEA.f(1289));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
				
		for (int tc = 1; tc <= T; tc++) {
			String s = sc.next();
			int[] mem = new int[s.length()];
			int cnt = 0;
			int bit = 0;
			
			for (int i = 0; i < mem.length; i++) {
				mem[i] = Integer.parseInt(s.substring(i,i+1));
			}
			
			for (int i = 0; i < mem.length; i++) {
				if(mem[i] != bit) {
					cnt++;
					bit = mem[i];
				}
			}
			
			System.out.printf("#%d %d\n", tc, cnt);
			
		}
		
		
	}

}
