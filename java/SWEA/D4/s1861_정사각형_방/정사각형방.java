package ssafy.im.solve.s1861_정사각형_방;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
//class Ans implements Comparable<Ans>{
//	int start;
//	int cnt;
//	public Ans(int start, int cnt) {
//		this.start=start;
//		this.cnt=cnt;
//	}
//	@Override
//	public int compareTo(Ans o) {
//		if(this.cnt==o.cnt) return this.start - o.start;
//		return o.cnt-this.cnt;
//	}
//}

public class 정사각형방 {
	static int T, N, START=987654321, CNT=-1;
	//static Ans ans;
	static int[][] map;
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("정사각형방.txt"));
		Scanner sc = new Scanner(System.in);
		T=sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			// 초기화
			START=987654321;
			CNT=-1;
			
			N=sc.nextInt();
			map=new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j]=sc.nextInt();
				}
			}
			//print(map);
			//모든 요소값이 시작점이 될수 있기 때문에 이중루프
			// 시작점을 바꾸는 루프
			//ans = new Ans(987654321,1);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					// 사방탐색후 1보다 큰곳이 있으면 이동
					//i, j, map[i][j]
					recursive(i,j,1,map[i][j]);		
				}
			}
			System.out.printf("#%d %d %d\n",tc,START,CNT);
			//System.out.printf("#%d %d %d\n",tc,ans.start,ans.cnt);
		}
	}
	
	private static void recursive(int r, int c, int cnt, int start) {
		
		// base part 없어요
		// 이동횟수가 가장큰 값을 저장한다
		// 단 최대이동횟수가 같으면 시작점이 작은 값을 저장한다
		if(cnt >= CNT) {
			if(start <= START) {
				CNT = cnt;
				START = start;
			}
		}
//		Ans tmp = new Ans(start,cnt);
//		if(ans.compareTo(tmp)>0) {
//			ans = tmp;
//		}
		
		for (int d = 0; d < 4; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			if(nr>=0&&nr<N&&nc>=0&&nc<N && map[nr][nc]==map[r][c]+1) {
				recursive(nr, nc, cnt+1, start);
			}
		}
		
	}

	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,1,-1};
	
	private static void print(int[][] map) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}

}
