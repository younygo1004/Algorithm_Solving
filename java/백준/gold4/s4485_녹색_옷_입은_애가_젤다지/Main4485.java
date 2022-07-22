package bj.gold4.s4485_녹색_옷_입은_애가_젤다지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Coordinate{
	int x;
	int y;
	
	public Coordinate(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
}

public class Main4485 {

	
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	static final int DIR_CNT = dx.length;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int tc = 1;
		
		while(true) {
			int N = Integer.parseInt(br.readLine());
			int ans = 0;
			
			if(N == 0) break;
			
			int[][] map = new int[N][N];
			
			for (int i = 0; i < map.length; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < map[i].length; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			boolean[][] isVisted = new boolean[N][N];
			int[][] distance = new int[N][N];
			
			for (int i = 0; i < distance.length; i++) {
				Arrays.fill(distance[i], Integer.MAX_VALUE);
			}
			
			distance[0][0] = map[0][0];
			
			for (int i = 0; i < map.length; i++) {
				
				for (int j = 0; j < map[i].length; j++) {
					
					int minDistance = Integer.MAX_VALUE;
					Coordinate coord = new Coordinate(-1, -1);
					
					for (int k = 0; k < distance.length; k++) {
						for (int l = 0; l < distance[i].length; l++) {
							if(!isVisted[k][l] && distance[k][l] < minDistance) {
								minDistance = distance[k][l];
								coord = new Coordinate(k, l);
							}
						}
					}
					
					isVisted[coord.x][coord.y] = true;

					
					for (int k = 0; k < DIR_CNT; k++) {
						int x = coord.x+dx[k];
						int y = coord.y+dy[k];
						if(x >= 0 && x < map.length && y >= 0 && y < map.length && !isVisted[x][y] && distance[x][y] > map[x][y] + distance[coord.x][coord.y]) {
							distance[x][y] = map[x][y] + distance[coord.x][coord.y];
						}
					}
					
				}
			}
			
			ans = distance[N-1][N-1];
			
			System.out.printf("Problem %d: %d\n", tc, ans);
			tc++;
			
		}
		
		br.close();

	}

}
