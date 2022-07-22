package bj.silver1.s9205_맥주_마시면서_걸어가기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Coordinate {
	int x;
	int y;

	public Coordinate(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Coordinate [x=" + x + ", y=" + y + "]";
	}

}

public class Solution9205_BFS {

	static final int MAX_DISTANCE = 1000; // 50 * 20 = 1000
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int num = Integer.parseInt(br.readLine());
			int x, y;
			boolean visitable = false; // 방문 가능 여부를 표시할 boolean 변수

			Coordinate human;
			Coordinate[] stores = new Coordinate[num];
			Coordinate festival;

			Queue<Coordinate> visitList = new LinkedList<Coordinate>();

			StringTokenizer st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			human = new Coordinate(x, y);

			for (int i = 0; i < stores.length; i++) {
				st = new StringTokenizer(br.readLine());
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				stores[i] = new Coordinate(x, y);

			}

			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			festival = new Coordinate(x, y);

			visitList.offer(human);
			boolean[] isVisted = new boolean[num];

			while (!visitList.isEmpty()) {
				Coordinate coord = visitList.poll();
				
				if(getDistance(coord, festival) <= MAX_DISTANCE) {
					visitable = true;
					break;
				}
					
				
				for (int i = 0; i < stores.length; i++) {
					if(!isVisted[i] && getDistance(coord, stores[i]) <= MAX_DISTANCE) {
						visitList.offer(stores[i]);
						isVisted[i] = true;
					}

				}
			}

			System.out.println(visitable ? "happy" : "sad");

		}

		br.close();

	}

	private static int getDistance(Coordinate start, Coordinate end) {
		
		return Math.abs(start.x - end.x) + Math.abs(start.y - end.y);
		
	}

}
