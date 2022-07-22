package bj.bronze2.s3040_백설_공주와_일곱_난쟁이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main3040 {
	static final int COUNT = 9;
	static final int SEVEN = 7;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] input = new int[COUNT];
		int sum = 0;
		
		int[] p = new int[COUNT];
		
		
		for (int i = 0; i < COUNT; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}
		
		
		br.close();
		
		for (int i = COUNT-1; i > COUNT-1-SEVEN ; i--) {
			p[i] = 1;
		}
		
		Arrays.sort(input);
		
		do {
			for (int i = 0; i < COUNT; i++) {
				if(p[i]==1) sum+=input[i];
				
			}
			
			if(sum == 100) {
				for (int i = 0; i < COUNT; i++) {
					if(p[i]==1) {
						System.out.println(input[i]);
						
					}
					
				}
				break;
			}
			
			sum = 0;
			
		} while (np(p));
	}

	private static boolean np(int[] numbers) {
		int N = numbers.length;
		
		
		// step1. 꼭대기를 찾는다. 꼭대기를 통해 교환위치(i-1) 찾기
		int i = N-1;
		while(i > 0 && numbers[i-1] >= numbers[i]) --i;
		
		// 꼭대기가 맨 앞이면 (더이상 만들 순열이 없으면)
		if(i==0) return false;
		
		// step2. i-1 위치값과 교환할 큰 값 찾기
		int j = N - 1;
		
		while(numbers[i-1]>=numbers[j]) --j;
		
		// step3. i-1 위치값과 j위치값 교환
		swap(numbers, i-1, j);
		
		// step4. 꼭대기부터 맨 뒤까지 내림차순 형태의 순열을 오름차순으로 변경
		int k = N-1;
		while(i<k) {
			swap(numbers, i++, k--);
		}
		
		return true;
	}
	
	private static void swap(int[] numbers, int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}

}
