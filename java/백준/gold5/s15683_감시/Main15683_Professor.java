package bj.gold5.s15683_감시;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Main15683_Professor {
	static int N,M, ans= Integer.MAX_VALUE;
	static int[][] map;
	static ArrayList<Camera> cameras = new ArrayList<>();
	//static Ans ans;
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("감시.txt"));
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		map= new int[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j]=sc.nextInt();
				if(map[i][j]>=1 && map[i][j]<=5) {
					cameras.add(new Camera(i, j, map[i][j]));
				}
			}
		}
		//print(map);
		solve(0,map);
		System.out.println(ans);
	}
	
	
	
	private static void solve(int idx,int[][] map) {
		// 모든 카메라의 탐색이 끝나면 종료
		if(idx==cameras.size()) {
			print(map);
			System.out.println("-----------------");
			// 사각지대 숫자 세기
			int cnt = 0;
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[0].length; j++) {
					if(map[i][j]==0) {
						cnt++;
					}
				}
			}
			ans = Math.min(ans, cnt);
			return;
		}
		
		Camera p = cameras.get(idx);
		
		// 카메라 마다의 사방탐색
		for (int d = 0; d < 4; d++) {
			int[][] tmap = mapCopy(map);
			// 카메라가 감시하는 방향에 대해서 체크
			for (int i = 0; i < dir[p.d].length; i++) {
				int nr = p.r;
				int nc = p.c;
				int nd = (dir[p.d][i]+d)%4;
				
				while(true) {
					nr = nr + dr[nd];
					nc = nc + dc[nd];
					if(!(nr>=0&&nr<N&&nc>=0&&nc<M) || tmap[nr][nc]==6) {
						break;
					}
					tmap[nr][nc]=9;
				}
			}
			solve(idx+1,tmap);
		}
		
	}
	
	static int[][] dir = {{},{1},{1,3},{0,1},{0,1,3},{0,1,2,3}};
	
	static int[] dr = {-1,0,1,0};   // 12 3 6 9
	static int[] dc = { 0,1,0,-1}; 
	
	private static int[][] mapCopy(int[][] map) {
		int[][] tmap = new int[N][M];
		for (int i = 0; i < tmap.length; i++) {
			for (int j = 0; j < tmap[0].length; j++) {
				tmap[i][j]=map[i][j];
			}
		}
		return tmap;
	}

	static class Camera {
		int r,c,d;
		Camera(int r, int c, int d){
			this.r=r;
			this.c=c;
			this.d=d;
		}
	}
	private static void print(int[][] map) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
}
