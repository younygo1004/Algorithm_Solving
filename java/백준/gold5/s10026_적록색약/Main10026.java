package bj.gold5.s10026_적록색약;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main10026 {
	
	static class RC{
		int row;
		int col;
		public RC(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		
		int N = Integer.parseInt(br.readLine());
		char[][] image = new char[N][N];
		boolean[][] common = new boolean[N][N];
		boolean[][] blind = new boolean[N][N];
		int comCnt = 0;
		int blindCnt = 0;
		
		for (int i = 0; i < image.length; i++) {
			image[i] = br.readLine().toCharArray();
 		}
		
		Queue<RC> queue1 = new LinkedList<RC>();
		Queue<RC> queue2 = new LinkedList<RC>();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!common[i][j]) {
					comCnt++;
					
					queue1.offer(new RC(i, j));
					common[i][j] = true;
					
					while(!queue1.isEmpty()) {
						
						RC rc = queue1.poll();
						
						
						for (int k = 0; k < 4; k++) {
							int r = rc.row+dr[k];
							int c = rc.col+dc[k];
							
							if(r >= 0 && r < N && c >= 0 && c < N && !common[r][c] && image[r][c] == image[rc.row][rc.col]) {
								common[r][c] = true;
								queue1.offer(new RC(r, c));
							}
							
						}
					}
				}
			}
			
			for (int j = 0; j < N; j++) {
				if(!blind[i][j]) {
					blindCnt++;
					
					queue2.offer(new RC(i, j));
					blind[i][j] = true;
					
					while(!queue2.isEmpty()) {
						
						RC rc = queue2.poll();
						
						
						for (int k = 0; k < 4; k++) {
							int r = rc.row+dr[k];
							int c = rc.col+dc[k];
							
							if(r >= 0 && r < N && c >= 0 && c < N && !blind[r][c] && isBlindSame(image[r][c], image[rc.row][rc.col])) {
								blind[r][c] = true;
								queue2.offer(new RC(r, c));
							}
							
						}
					}
				}
			}
			
		}
		
		System.out.printf("%d %d\n", comCnt, blindCnt);
		
		
		
		
		br.close();
		
		
	}
	
	private static boolean isBlindSame(char a, char b) {
		if(a == 'R' || a == 'G') {
			if(b == 'R' || b == 'G')
				return true;
			else
				return false;
		}
		if(a==b)
			return true;
		return false;
	}

}
