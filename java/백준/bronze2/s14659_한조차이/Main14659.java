package bj.bronze2.s14659_한조차이;

import java.io.FileNotFoundException;
import java.util.Scanner;

import bj.BJ;

public class Main14659 {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(BJ.f(14659));
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arrows = new int[N];
		int max = 0;
		
		for (int i = 0; i < arrows.length; i++) {
			arrows[i] = sc.nextInt();
		}
		
		for (int i = 0; i < arrows.length; i++) {
			int cnt = 0;
			
			for (int j = i+1; j < arrows.length; j++) {
				if(arrows[i] < arrows[j]) {
					i = j-1;
					break;
				}
				cnt++;
				
			}
			max = Math.max(max, cnt);
		}
		
		System.out.println(max);

	}

}
