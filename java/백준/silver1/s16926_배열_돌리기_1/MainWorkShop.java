package bj.silver1.s16926_배열_돌리기_1;

import java.io.IOException;
import java.util.Scanner;

/*
 * 문제번호 : 백준 16926 / 배열 돌리기 1
 * 분류 : 구현 
 * 일자 : 2021.08.11
 * 접근 : 몇번 돌릴 것인가, 방향전환 어떻게? 
 */
public class MainWorkShop {
	static int N,M,R;
	static int[][] map;
	// 북 : 0 동 : 1 남 : 2 서 : 3
	// 뒤에 있는 데이터를 앞에다 옮겨야 하므로 실제 방향은 시계방향으로 가야 함 
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		R = sc.nextInt();
		
		map = new int[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				map[i][j] = sc.nextInt();
			}
		}
		// 돌릴 사각형의 횟수를 구하기
		// > 짧은변 / 2를 계산 
		int step = Math.min(N, M) / 2;
		
		for(int l=0;l<R;l++) {
			for(int d=0;d<step;d++) {
				// d는 안쪽으로 들어가는 사각형들의 시작좌표라고 생각(0,0 > 1,1 > 2,2)
				int Sr = d;// 시작점
				int Sc = d;
				int dir = 0;
				// 앞에 값을 미리 복사 
				int tmp = map[Sr][Sc];
				while(dir<4) { // 방향이 4번바뀔때까지 돌음 
					int nr = Sr+dr[dir];
					int nc = Sc+dc[dir];
					// 벽에 닿았을 때 방향 전환 
					if(nr>=d&&nr<N-d&&nc>=d&&nc<M-d) {
						map[Sr][Sc] = map[nr][nc];
						Sr = nr;
						Sc = nc;
					} else { // 경계선을 벗어나면 방향 전환 
						dir++;						
					}
				}
				map[d+1][d] = tmp;
				
			}
		}
		
		print(map);
	}
	private static void print(int[][] map2) {
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		
	}
}