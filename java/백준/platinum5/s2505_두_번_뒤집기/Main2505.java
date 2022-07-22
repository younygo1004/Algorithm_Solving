package bj.platinum5.s2505_두_번_뒤집기;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

import bj.BJ;

public class Main2505 {

	public static void main(String[] args) throws FileNotFoundException {

		System.setIn(BJ.f(2505));
		Scanner sc = new Scanner(System.in);

		int[][] idxs = {{1,1},{1,1}}; // 뒤집은 두번의 인덱스 값을 저장할 배열 선언, 초기화

		int N = sc.nextInt() + 1; // 숫자판 크기 + 1 (배열 고려)
		int[] init = new int[N]; // 초기 상태 배열
		int[] rev = new int[N]; // 2번 뒤집은 상태의 배열

		for (int i = 1; i < N; i++) { // 배열 초기화
			init[i] = i; // 초기 배열 상태
			rev[i] = sc.nextInt(); // 입력받은 배열 상태
		}
		
		for (int i = 0; i < idxs.length; i++) {
			
			if(init.equals(rev))
				break;
			
			reverse(init, rev, idxs[i]);
			
		}
		
		System.out.println();
		sc.close();

	}
	
	/**
	 * 시작 배열을 마지막 배열로 만들어가기 위한 method
	 * @param init	초기 상태의 배열
	 * @param rev	마지막 상태의 배열
	 * @param idxs	뒤집은 시작 인덱스와 끝 인덱스의 값을 저장할 배열
	 */
	static void reverse(int[] init, int[] rev, int[] idxs) {

		oneReverse: for (int i = 1; i < init.length; i++) {
			int start;
			int end = init.length-1;
			if (init[i] != rev[i]) {
				start = i;
				for (int j = start; j < init.length; j++) {
					if (init[j] == rev[j])
						end = j;
					
					for (int k = start; k < end; k++) {
						int idx = init.length - start;
						swap(init, start, idx);
					}
				}
			}
		}
	
	
	}
	
	/**
	 * 1차원 int 배열의 두 값을 바꿔주는 함수
	 * @param arr	바꿀 배열의 시작 주소
	 * @param i		바꾸고자 하는 첫 번째 인덱스
	 * @param j		바꾸고자 하는 두 번째 인덱스
	 */
	static void swap(int[] arr, int i, int j) {
		
		int tmp = arr[j];
		arr[j] = arr[i];
		arr[i] = tmp;
		
	}

}
