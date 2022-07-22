package bj.bronze3.s8320_직사각형을_만드는_방법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import bj.BJ;

public class Main8320 {

	public static void main(String[] args) throws IOException {
//		System.setIn(BJ.f(8320));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int squares = Integer.parseInt(br.readLine());
		
		int ans = 1; // 정사각형을 한개만 사용할 때 횟수로 초기화
		
		for (int i = 2; i <= squares; i++) { // i = 사용할 정사각형의 갯수 <= 주어진 정사각형 갯수 
			
			ans++; // 무조건 한개는 만들 수 있으므로
			
			int iter = i; // 약수 탐색을 위한 변수
			for (int j = 2; j < iter; j++) { // 1과 자기자신을 제외한 약수를 탐색
				
				if(i%j == 0) { // 약수를 찾으면
					ans++; 
					iter = i/j;
				}
				
			}
		}
		
		System.out.println(ans);
		
		br.close();
		

	}

}
