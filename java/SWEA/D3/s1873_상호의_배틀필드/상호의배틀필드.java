package ssafy.im.solve.s1873_배틀필드;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class 상호의배틀필드 {
	static int T;
	static int N, M;
	static char[][] map;

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("상호의배틀필드.txt"));
		Scanner sc = new Scanner(System.in);
		T=sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N=sc.nextInt();
			M=sc.nextInt();
			map = new char[N][M];
			for (int i = 0; i < N; i++) {
				String str = sc.next();
				for (int j = 0; j < M; j++) {
					map[i][j]=str.charAt(j);
				}
			}
			//print(map);
			
			int cnt = sc.nextInt();
			String command = sc.next();
			int Sr=-1,Sc=-1;
			char Td='0';
			// 탱크를 찾자
			L:for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if(map[r][c]=='^'||map[r][c]=='v'||map[r][c]=='>'||map[r][c]=='<') {
						Sr = r;
						Sc = c;
						Td=map[r][c];
						break L;
					}
				}
			}
			
			// 명령실행
			for (int c = 0; c < cnt; c++) {
				char ch = command.charAt(c);
				// 
				switch (ch) {
				case 'U':
					// 
					Td='^';
					map[Sr][Sc]='^';
					if(check(Sr-1,Sc) && map[Sr-1][Sc]=='.') {
						map[Sr-1][Sc]='^';
						map[Sr][Sc]='.';
						Sr = Sr-1;
					}
					break;
				case 'D':
					
					break;
				case 'L':
					
					break;
				case 'R':
					
					break;
				case 'S':
					if(Td=='>') {
						int nr = Sr;
						int nc = Sc+1;
						while(check(nr,nc)) {
							if(map[nr][nc]=='*') {
								map[nr][nc]='.';
								break;
							}
							if(map[nr][nc]=='#') {
								break;
							}
							nc +=1;
						}
					}else if(Td=='<') {
						
					}else if(Td=='^') {
						
					}else if(Td=='v') {
						
					}
					break;

				default:
					break;
				}
				
				
			}
			
			
			// 결과지도 출력
			print(map);
			
		}
	}

	private static boolean check(int r, int c) {
		if (r >= 0 && r < N && c >= 0 && c < M) {
			return true;
		}
		return false;
	}

	private static void print(char[][] map) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}
