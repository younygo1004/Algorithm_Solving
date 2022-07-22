package swea.D3.s6808_규영이와_인영이의_카드게임;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution6808 {
	static final int COUNT = 18;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		ArrayList<Integer> cards = new ArrayList<Integer>();
		int[] myCards = new int[COUNT / 2];
		int[] enemyCards = new int[COUNT / 2];
		

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < COUNT; i++) {
			cards.add(i + 1);
		} // card 배열 초기화

		for (int tc = 1; tc <= T; tc++) {
			int sum = 0;
			int myWin = 0;
			int enemyWin = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int i = 0; i < COUNT / 2; i++) { // 고정 카드 
				int card = Integer.parseInt(st.nextToken());
				myCards[i] = card;
				
				for (int j = 0; j < cards.size(); j++) {
					if (cards.get(j).equals(card))
						cards.remove(j);
				}
			}

			for (int i = 0; i < COUNT / 2; i++) { // 순열 돌릴 카드
				enemyCards[i] = cards.remove(0);
			}
			
			Arrays.sort(enemyCards); // 배열 정렬
			
			
			do {
				
				for (int i = 0; i < COUNT/2; i++) {
					int score = myCards[i] - enemyCards[i];
					
					if(score > 0) sum += myCards[i] + enemyCards[i];
					else sum -= myCards[i] + enemyCards[i];
					
				}
				if(sum>0) myWin++;
				else enemyWin++;
				
				
				
				sum = 0;
				
			} while (permutation(enemyCards));

			sb.append("#"+ tc + " " + myWin + " " + enemyWin + "\n");

			for (int i = 0; i < COUNT; i++) {
				cards.add(i + 1);
			} // card 배열 초기화

		}
		
		System.out.println(sb);

		br.close();

	}

	private static boolean permutation(int[] enemyCards) {
		
		int N = enemyCards.length;
		
		int i = N - 1;
		
		while(0 < i && enemyCards[i-1] >= enemyCards[i]) --i;
		
		if(i == 0) return false;
		
		int j = N - 1;
		
		// 꼭대기를 기준으로 왼쪽에 있는 값보다 큰 값중 가장 작은 값을 탐색
		while(enemyCards[i-1]>=enemyCards[j]) --j;
		
		swap(enemyCards, i-1, j);
		
		int k = N - 1;

		for (int l = i; l < i + (enemyCards.length - i)/2 ; l++) {
			swap(enemyCards, l, k-l+i);
		}
		
		
		return true;
	}
	
	private static void swap(int[] arr, int i, int j) {
		
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
		
	}

	

}
