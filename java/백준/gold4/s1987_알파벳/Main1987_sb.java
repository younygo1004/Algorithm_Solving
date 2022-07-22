package bj.gold4.s1987_알파벳;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1987_sb {
	
	// 상,하,좌,우
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static char[][] board;
	static int ans = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer	st = new StringTokenizer(br.readLine());
		
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		board = new char[R][C];
		
		for (int i = 0; i < board.length; i++) {
			String s = br.readLine();
			board[i] = s.toCharArray();
		}
		
		searchMaxStringLength(0, 0, new StringBuilder(""));
		
		System.out.println(ans);
		
		br.close();
		
	}
	
	/**
	 * 보드에서 만들 수 있는 가장 긴 문자열의 길이를 찾는 method
	 * @param row 현재 행 위치
	 * @param col 현재 열 위치
	 * @param str 만들어낸 문자열
	 */
	private static void searchMaxStringLength(int row, int col, StringBuilder str) {
		
		System.out.println(str);
		
//		if(isEnd(row, col, str)) {
			
//			return;
//		}
		
		
		for (int i = 0; i < 4; i++) {
			int r = row + dr[i];
			int c = col + dc[i];
			
			str.append(board[row][col]);
			
			
			if(r >= 0 && r < board.length && c >= 0 && c < board[0].length && !isEnd(r, c, str)) {
				searchMaxStringLength(r, c, str);
				str.delete(str.length()-1, str.length());
				ans = Math.max(ans, str.length());
				
			}
			
		}
		
		
	}
	
	/**
	 * 현재 보드의 알파벳이 이미 만들어진 문자열에 있는지를 확인
	 * @param row 현재 행 위치
	 * @param col 현재 열 위치
	 * @param str 현재까지 만들어진 문자열
	 * @return	  문자열에 있는 문자면 true, 없는 문자면 false 반환
	 */
	private static boolean isEnd(int row, int col, StringBuilder str) {
		
		if(str.toString().contains(Character.toString(board[row][col])))
			return true;
		
		return false;
		
	}

}
