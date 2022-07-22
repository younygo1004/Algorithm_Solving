package swea.모의_SW_역량테스트.s4014_활주로_건설;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution4014 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		
		StringTokenizer st = null;
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			
			
			int N = Integer.parseInt(st.nextToken()); // 맵크기
			int x = Integer.parseInt(st.nextToken()); // 경사로 길이 (높이 : 1, 너비 : x)
			
			int[][] map = new int[N][N];
			int cnt = 0;
			
			for (int i = 0; i < map.length; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < map[i].length; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < N; i++) {
				if(check(i, N, x, map, true))
					cnt++;
				if(check(i, N, x, map, false))
					cnt++;
				
			}
			
			System.out.printf("#%d %d\n", tc, cnt);
		}
		
		
		br.close();
		
	}
	
	private static boolean check(int start, int size, int x, int[][] map, boolean isCol) {
		
		boolean[] isUsed = new boolean[size];
		
		if(isCol) {
			for (int i = 0; i < size-1; i++) {
				if(Math.abs(map[start][i] - map[start][i+1]) >= 2) //인접한 두 지형의 높이차가 2이상인 경우
					return false;
				else if(map[start][i] > map[start][i+1]) { // 뒤가 더 낮고, 차이가 1인 경우
					
					if(i+x >= size) // 만약 경사로 설치할 공간이 모자라면
						return false;
					
					// 공간이 모자라지 않다면
					int height = map[start][i+1];
					for (int j = i+1; j <= i+x; j++) { // 경사로를 세울 구간을 검사
						if(isUsed[j] || map[start][j] != height) // 만약 경사로를 세울 수 없거나, 이미 해당 지형에 경사로가 있으면
							return false;
					}
					for (int j = i+1; j <= i+x; j++) { // 경사로를 세울 수 있으면 일단 세운다.
						isUsed[j] = true;
					}
					
				}
				else if(map[start][i] < map[start][i+1]) { // 뒤가 더 높고, 차이가 1인 경우
					if(i-x+1 < 0) // 만약 경사로 설치할 공간이 모자라면
						return false;
					
					// 공간이 모자라지 않다면
					int height = map[start][i];
					for (int j = i-x+1; j <= i; j++) { // 경사로를 세울 구간을 검사
						if(isUsed[j] || map[start][j] != height) // 만약 경사로를 세울 수 없거나, 이미 해당 지형에 경사로가 있으면
							return false;
					}
					for (int j = i-x+1; j <= i; j++) { // 경사로를 세울 수 있으면 일단 세운다.
						isUsed[j] = true;
					}
					
				}
			}
		}
		else {
			for (int i = 0; i < size-1; i++) {
				if(Math.abs(map[i][start] - map[i+1][start]) >= 2) //인접한 두 지형의 높이차가 2이상인 경우
					return false;
				else if(map[i][start] > map[i+1][start]) { // 뒤가 더 낮고, 차이가 1인 경우
					
					if(i+x >= size) // 만약 경사로 설치할 공간이 모자라면
						return false;
					
					// 공간이 모자라지 않다면
					int height = map[i+1][start];
					for (int j = i+1; j <= i+x; j++) { // 경사로를 세울 구간을 검사
						if(isUsed[j] || map[j][start] != height) // 만약 경사로를 세울 수 없거나, 이미 해당 지형에 경사로가 있으면
							return false;
					}
					for (int j = i+1; j <= i+x; j++) { // 경사로를 세울 수 있으면 일단 세운다.
						isUsed[j] = true;
					}
					
				}
				else if(map[i][start] < map[i+1][start]) { // 뒤가 더 높고, 차이가 1인 경우
					if(i-x+1 < 0) // 만약 경사로 설치할 공간이 모자라면
						return false;
					
					// 공간이 모자라지 않다면
					int height = map[i][start];
					for (int j = i-x+1; j <= i; j++) { // 경사로를 세울 구간을 검사
						if(isUsed[j] || map[j][start] != height) // 만약 경사로를 세울 수 없거나, 이미 해당 지형에 경사로가 있으면
							return false;
					}
					for (int j = i-x+1; j <= i; j++) { // 경사로를 세울 수 있으면 일단 세운다.
						isUsed[j] = true;
					}
					
				}
			}
		}
		
		return true;
	}

}

