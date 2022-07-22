package swea.D3.s1873_상호의_배틀필드;

import java.util.Arrays;
import java.util.Scanner;

public class Solution1873 {

	static int[] dr = { -1, 1, 0, 0 }; // up, down, left, right
	static int[] dc = { 0, 0, -1, 1 };
	static char[] dt = {'^', 'v', '<', '>'}; // 탱크 기호 저장

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int row = sc.nextInt();
			int col = sc.nextInt();
			int[] tank = new int[3]; // 0: 방향, 1: row위치, 2: col위치
			char[] move;

			char[][] map = new char[row][col];

			for (int i = 0; i < row; i++) {
//				String s = sc.next();
				map[i] = sc.next().toCharArray(); // 한행씩 값 입력하기
				for (int j = 0; j < map[i].length; j++) { // 입력된 행에서
					char cmp = map[i][j];
					
					for (int k = 0; k < dt.length; k++) {
						if(cmp == dt[k]) {
							tank[0] = k;
							tank[1] = i;
							tank[2] = j;
						}
					}

				}
			}
			
			sc.nextInt(); // 필요없는 값 날리기
			move = sc.next().toCharArray(); // 명령어 저장

			for (int i = 0; i < move.length; i++) {
				int way = -1; // 방향 지정
				switch (move[i]) {
				case 'U':
					way = 0;
					break;
				case 'D':
					way = 1;
					break;
				case 'L':
					way = 2;
					break;
				case 'R':
					way = 3;
					break;
				case 'S': // 탱크가 바라보는 방향으로 대포 날리기
					int r = tank[1];
					int c = tank[2];
					
					bombLoop:
					while (true) {
						r += dr[tank[0]];
						c += dc[tank[0]];
						
						if (r >= 0 && r < row && c >= 0 && c < col) { // 맵을 벗어나지 않았으면
							if(map[r][c] == '*') { // 벽돌로 만들어진 벽은
								map[r][c] = '.'; // 평지가 된다.
								break bombLoop;
							}
							if(map[r][c] == '#') { // 강철로 만들어진 벽은
								break bombLoop; // 부수지 못한다.
							}
						}
						else // 맵을 벗어나도 벗어난다
							break bombLoop;
					}
					break;

				default:
					break;
				}
				if (way != -1) { // 대포를 쏜게 아니라면
					int r = dr[way] + tank[1];
					int c = dc[way] + tank[2];
					char mode = dt[way];
					if (r >= 0 && r < row && c >= 0 && c < col) { // 맵을 벗어나지 않았으면
						if (map[r][c] == '.') { // 만약 평지면
							map[tank[1]][tank[2]] = '.'; // 탱크가 있던 자리를 벗어나서
							map[r][c] = mode; // 탱크가 전진
							tank[0] = way;
							tank[1] = r;
							tank[2] = c; // 탱크의 방향, 좌표 저장

						}
						else { // 이동할 수 없으면 방향만 변경
							map[tank[1]][tank[2]] = dt[way]; // 이동하지 않더라도 방향은 바꿔준다
							tank[0] = way;
						}
					}
					else {
						map[tank[1]][tank[2]] = dt[way]; // 맵을 벗어날수 없으므로 방향만 바꿔준다
						tank[0] = way;
					}
				}

			}
			
			System.out.printf("#%d ", tc);
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}

		}
		sc.close();
	}

}
