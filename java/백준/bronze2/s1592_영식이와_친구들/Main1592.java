package bj.bronze2.s1592_영식이와_친구들;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import bj.BJ;

public class Main1592 {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(BJ.f(1592));
		Scanner sc = new Scanner(System.in);
		
		int N, M, L;	
		int[] humans;
		int cnt = 0;
		int balls = 0;
		int idx = 0;
		
		N = sc.nextInt();
		M = sc.nextInt();
		L = sc.nextInt();
		
		humans = new int[N];
		humans[0] = 1; // 초기화
		
		while(balls != M) {
			if(humans[idx]%2 == 0 ) { // 공을 받은 횟수가 짝수번이면
				idx = idx - L;
				if(idx < 0)
					idx = N + idx;
				
			}
			else // 홀수번이면
				idx = (idx + L) % N;
			
			
			balls = ++(humans[idx]);
			cnt++;
		}
		
		System.out.println(cnt);
		sc.close();
	}

}
