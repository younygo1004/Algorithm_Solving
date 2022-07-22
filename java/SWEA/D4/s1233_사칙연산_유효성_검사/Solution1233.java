package swea.D4.s1233_사칙연산_유효성_검사;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

import swea.SWEA;

public class Solution1233 {
	
	static final int T = 10;

	public static void main(String[] args) throws IOException {
		System.setIn(SWEA.f(1233));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int len;
		String[] strs;
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean isCalculate;
		
		for (int tc = 1; tc <= T; tc++) {
			isCalculate = true;
			len = Integer.parseInt(br.readLine());
			System.out.println(len);
			
			
			char[] binTree = new char[len+1];
			
			for (int i = 1; i <= len; i++) {
				strs = br.readLine().split(" ");
				binTree[i] = strs[1].charAt(0);
				
			}
			queue.offer(1);
			
			int current = 0;
			while(!queue.isEmpty()) {
				current = queue.poll();
				
				if(current*2 <= len) {
					queue.offer(current*2);
				}
				else { // 연산이 불가능한 경우를 검사
					if(binTree[current] == '+' || binTree[current] == '-' || binTree[current] == '*' || binTree[current] == '/') {
						isCalculate = false;
						break;
					}
						
				}
				
				if(current*2+1 <= len) {
					queue.offer(current*2+1);
				}
				else { // 연산이 불가능한 경우를 검사
					if(binTree[current] == '+' || binTree[current] == '-' || binTree[current] == '*' || binTree[current] == '/') {
						isCalculate = false;
						break;
					}
						
				}
			}
			
			queue.clear();
			
			if(isCalculate)
				System.out.printf("#%d 1\n", tc);
			else
				System.out.printf("#%d 0\n", tc);
			
			
		}
		
		br.close();
	}

}
