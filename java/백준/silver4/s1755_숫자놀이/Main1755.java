package bj.silver4.s1755_숫자놀이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main1755 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력을 받아들일 BufferedReader 생성
		
		StringTokenizer	st = new StringTokenizer(br.readLine()); // M과 N을 띄어쓰기 단위로 자르기 위한 Tokenizer
		
		int M = Integer.parseInt(st.nextToken()); // Tokenizer의 첫 번째 값을 M에 입력
		int N = Integer.parseInt(st.nextToken()); // Tokenizer의 두 번째 값을 N에 입력
		
		ArrayList<Integer> numList = new ArrayList<Integer>(); // Integer 값을 받아들일 ArrayList 생성
		
		for (int i = M; i <= N; i++) { 
			numList.add(i); // M과 N 사이의 값을 ArrayList에 넣기
		}
		
		Comparator<Integer> comp = new Comparator<Integer>() { // Integer 클래스의 정렬 기준을 설정할 Comparator 생성
			
			
			
			
			@Override
			public int compare(Integer o1, Integer o2) { // Comparator의 compare 메소드 구현
				
				String[] numStr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"}; // 정렬 기준이 될 문자열
				
				// o1과 o2를 저장
				int num1 = o1;
				int num2 = o2;
				
				// 정렬의 기준이 될 문자열을 저장할 StringBuilder
				StringBuilder s1 = new StringBuilder("");
				StringBuilder s2 = new StringBuilder("");
				
				
				while (num1 >= 10) { // 맨 앞자리가 비교 기준이 될 것이므로, 맨 앞자리의 숫자만 남을때까지 나눠주기
					// 나머지를 문자열로 변환해서 넣어주기, 10으로 나눈 값으로 반복하기	
					StringBuilder s = new StringBuilder(numStr[num1%10]); 
					s1 = s.append(s1);
					num1 = num1 / 10;
					
				}
				
				
				s1 = new StringBuilder(numStr[num1%10]).append(s1); // 마지막 남은 숫자를 문자열로 변환해서 넣어주기
				
				while (num2 >= 10) { // 맨 앞자리가 비교 기준이 될 것이므로, 맨 앞자리의 숫자만 남을때까지 나눠주기
					// 나머지를 문자열로 변환해서 넣어주기, 10으로 나눈 값으로 반복하기
					StringBuilder s = new StringBuilder(numStr[num2%10]);
					s2 = s.append(s2);
					num2 = num2 / 10;
					 
				}
				s2 = new StringBuilder(numStr[num2%10]).append(s2); // 마지막 남은 숫자를 문자열로 변환해서 넣어주기
				
				return s1.toString().compareTo(s2.toString()); // 두 문자열의 비교값을 리턴
			}
		};
		
		Collections.sort(numList, comp); // Collections의 sort와 정의된 Comparator를 이용하여 정렬
		
		for (int i = 0; i < numList.size(); i++) { // 배열 출력
			
			System.out.print(numList.get(i));
			if((i+1)%10 == 0) System.out.println(); // 나눠주기
			else System.out.print(" ");
		}
		
		
		
		br.close(); // BufferdReader 닫기
	}

}
