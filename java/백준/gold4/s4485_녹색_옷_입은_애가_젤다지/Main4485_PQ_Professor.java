package bj.gold4.s4485_녹색_옷_입은_애가_젤다지;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main4485_PQ_Professor {
	static int N;
	static int[][] map;
	static boolean[][] v;

	public static void main(String[] args) throws FileNotFoundException {
//		System.setIn(new FileInputStream("녹색옷을입은애가젤다지.txt"));
		Scanner sc = new Scanner(System.in);
		int cnt=0;
		while (true) {
			cnt++;
			Ans=0;
			N = sc.nextInt();
			if(N==0) break;
			map = new int[N][N];
			v = new boolean[N][N];

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					map[r][c] = sc.nextInt();
				}
			}
			//print(map);
			solve();
			System.out.printf("Problem %d: %d\n",cnt,Ans);
		}
	}
	static int[] dr= {1,-1,0,0};
	static int[] dc= {0,0,1,-1};
	static int Ans;
	private static void solve() {
		PriorityQueue<Point> Q = new PriorityQueue<>();
		Q.add(new Point(0, 0, map[0][0]));
		v[0][0]=true;
		while(!Q.isEmpty()) {
			Point p = Q.poll();
			if(p.r==N-1&&p.c==N-1) {
				Ans = p.weight;
			}
			for (int d = 0; d < 4; d++) {
				int nr = p.r+dr[d];
				int nc = p.c+dc[d];
				if(nr>=0&&nr<N&&nc>=0&&nc<N&&!v[nr][nc]) {
					Q.add(new Point(nr, nc, p.weight+map[nr][nc]));
					v[nr][nc]=true;
				}
			}
		}
	}
	
	static class Point implements Comparable<Point>{
		int r,c, weight;
		Point(int r, int c, int weight){
			this.r=r;
			this.c=c;
			this.weight=weight;
		}
		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.weight, o.weight);
		}
	}
	private static void print(int[][] map2) {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				System.out.print(map[r][c] + " ");
			}
			System.out.println();
		}
	}

}
