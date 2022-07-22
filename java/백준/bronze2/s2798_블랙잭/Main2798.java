package bj.bronze2.s2798_블랙잭;


import java.io.FileNotFoundException;
import java.util.Scanner;

import bj.BJ;

public class Main2798 {
	public static void main(String[] args) throws FileNotFoundException {
		
		System.setIn(BJ.f(2798));
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int max = Integer.MIN_VALUE;
		
		int[] cards = new int[N];
		
		
		for (int i = 0; i < cards.length; i++) {
			cards[i] = sc.nextInt();
		}
		
		cardLoop:
		for (int i = 0; i < cards.length; i++) {
			for (int j = i+1; j < cards.length; j++) {
				for (int k = j+1; k < cards.length; k++) {
					int tmp = cards[i] + cards[j] +cards[k];
					
					if(tmp == M) {
						max = tmp;
						break cardLoop;
					}
					
					if (tmp < M) 
						max = Integer.max(max, tmp);
					
				}
			}
		}
		
		System.out.println(max);
		
		
	}

}
