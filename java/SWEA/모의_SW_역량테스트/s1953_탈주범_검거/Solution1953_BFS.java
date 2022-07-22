package swea.모의_SW_역량테스트.s1953_탈주범_검거;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Coordinate{
	int r;
	int c;
	
	public Coordinate(int r, int c) {
		super();
		this.r = r;
		this.c = c;
	}
	
	
}

public class Solution1953_BFS {
	
	static int[][] dr = {null, {-1, 1, 0, 0}, {-1, 1, 0, 0}, {0, 0, 0, 0}, {-1, 0, 0, 0}, {0, 1, 0, 0}, {0, 1, 0, 0}, {-1, 0, 0, 0}};
	static int[][] dc = {null, {0, 0, -1, 1}, {0, 0, 0, 0}, {0, 0, -1, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, -1, 0}, {0, 0, -1, 0}};
	static String[] isLinked = {"1256", "1247", "1345", "1367"};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("BFS");
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			int ans = 0;
			
			StringTokenizer	st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[N][M];
			boolean[][] visit = new boolean[N][M];
			
			for (int i = 0; i < map.length; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < map[i].length; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					
				}
//				System.out.println(Arrays.toString(map[i]));
			}
			
			if(map[R][C] == 0) {
				System.out.printf("#%d %d\n", tc, ans);
				continue;
			}
			
			
			// BFS 시작 (level-wise)
			Queue<Coordinate> queue = new LinkedList<Coordinate>();
			
			queue.offer(new Coordinate(R, C)); // 시작위치 지정
			
			for (int i = 1; i <= time; i++) {
				
				ArrayList<Coordinate> curList = new ArrayList<Coordinate>();
				
				while(!queue.isEmpty()) { // 현재 시간에 갈수 있는 곳 모두 가보기
					Coordinate cur = queue.poll();
					visit[cur.r][cur.c] = true;
					
					curList.add(cur);
				}
				
				while(!curList.isEmpty()) { // 다음 시간에 갈수 있는 곳 저장
					Coordinate cur = curList.remove(curList.size()-1);
					
					for (int j = 0; j < 4; j++) { // 사방탐색
						// 현재위치의 파이프 종류에 따른 nr, nc값 지정
						int nr = cur.r + dr[map[cur.r][cur.c]][j];
						int nc = cur.c + dc[map[cur.r][cur.c]][j];
						
						// row와 col값이 맵의 범위를 벗어나지 않고, 방문하지 않았으며, 현재 위치와 파이프로 연결되어 있으면
						if(nr >= 0 && nr < N && nc >= 0 && nc < M && !visit[nr][nc] && isLinked[j].contains(Integer.toString(map[nr][nc])) ) {
							queue.offer(new Coordinate(nr, nc)); // 다음 시간에 (nr,nc)좌표로 도망칠 수 있음.
						}
						
					}
				}
				
				
			}
			// BFS 끝
			
			for (int i = 0; i < visit.length; i++) { // 갈수있는 개수 세기
				for (int j = 0; j < visit[i].length; j++) {
					if(visit[i][j])
						ans++;
				}
			}
			
			
			System.out.printf("#%d %d\n", tc, ans);
		}
		
		
		
		br.close();
		
	}

}
