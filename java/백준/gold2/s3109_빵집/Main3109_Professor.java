package bj.gold2.s3109_빵집;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main3109_Professor {
	static int R,C, cnt;
	static char[][] map;
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("빵집.txt"));
		Scanner sc = new Scanner(System.in);
		R=sc.nextInt();
		C=sc.nextInt();
		map=new char[R][C];
		for (int r = 0; r < R; r++) {
			String str = sc.next();
			for (int c = 0; c < C; c++) {
				map[r][c]=str.charAt(c);
			}
		}
		
		//print(map);
		for (int i = 0; i < R; i++) {
			map[i][0]='o';
			dfs(i,0);
		}
		System.out.println(cnt);
	}
	
	private static boolean dfs(int r, int c) {
		if(c==C-1) {
			cnt++;
			//print(map);
			//System.out.println("---------------------");
			return true;
		}
		for (int d = 0; d < dc.length; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			if(nr>=0 &&nr<R && nc>=0 && nc<C && map[nr][nc]=='.') {
				map[nr][nc]='o';
				
				if(dfs(nr, nc)) return true;
				
				//return dfs(nr,nc);
			
			}
		}
		return false;
	}

	static int[] dr= {-1,0,1};
	static int[] dc= {1,1,1};
	private static void print(char[][] map) {
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				System.out.print(map[r][c]+" ");
			}
			System.out.println();
		}
	}

}
