package bj.gold4.s17135_캐슬_디펜스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Position {
	private int row;
	private int col;

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public Position(int row, int col) {
		super();
		this.row = row;
		this.col = col;
	}

	@Override
	public String toString() {
		return "Position [row=" + row + ", col=" + col + "]";
	}

}

public class Main17135 {
	static final int COUNT = 3;
	static int MAX = Integer.MIN_VALUE;
	static int LIMIT = 0;
	static int N, M;

	static ArrayList<Position> arrows = new ArrayList<>();
	static ArrayList<Position> enemys = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // row 값
		M = Integer.parseInt(st.nextToken()); // col 값
		LIMIT = Integer.parseInt(st.nextToken()); // 공격 범위

		for (int row = 1; row <= N; row++) { // 적의 좌표 입력
			st = new StringTokenizer(br.readLine());

			for (int col = 1; col <= M; col++) {
				String s = st.nextToken();
				if (s.equals("1"))
					enemys.add(new Position(row, col));

			}
		}

		for (int i = 1; i <= M; i++) { // 궁수를 배치할 수 있는 곳의 좌표값 입력
			arrows.add(new Position(N + 1, i));
		}

		combinationChicken(new Position[COUNT], 0, 0);

		System.out.println(MAX);

		br.close();

	}

	/**
	 * 제거 가능한 적의 최댓값을 찾기 위한 recursive method
	 * 
	 * @param selArrows 궁수를 어디에 배치할 것인지 선택하기 위한 배열
	 * @param idx       궁수를 배치할 수 있는 좌표값을 가진 배열 탐색을 위한 인덱스
	 * @param k         궁수를 어디에 배치할 것인지 선택하기 위한 인덱스
	 */
	private static void combinationChicken(Position[] selArrows, int idx, int k) {

		if (k == selArrows.length) { // 궁수를 다 배치하면

			ArrayList<Position> tmp = new ArrayList<>();

			for (int i = 0; i < enemys.size(); i++) {
				Position p = enemys.get(i);
				tmp.add(new Position(p.getRow(), p.getCol()));

			}
			int cnt = getEnemyCount(selArrows, tmp);

			MAX = Math.max(MAX, cnt);

			return;
		}

		if (idx == arrows.size()) { // 궁수를 배치할 수 있는 배열을 다 보면
			return;
		}

		// 조합을 뽑아낸다.
		for (int i = idx; i < arrows.size(); i++) {
			selArrows[k] = arrows.get(i);

			combinationChicken(selArrows, i + 1, k + 1);

		}

	}

	/**
	 * 궁수의 배치에 따른 제거 가능한 적의 수를 구하는 method
	 * 
	 * @param selArrows 궁수의 배치 배열
	 * @param tmp       적의 배치 배열의 복사본
	 * @return 제거 가능한 적의 수
	 */
	private static int getEnemyCount(Position[] selArrows, ArrayList<Position> tmp) {
		int count = 0;

		while (!tmp.isEmpty()) { // 적이 다 사라질때까지

			ArrayList<Position> removeEnemys = new ArrayList<>();

			for (int i = 0; i < selArrows.length; i++) { // 궁수마다 제거할 적을 선택
				ArrayList<Position> attackableEnemys = new ArrayList<>();

				Position arrow = selArrows[i]; // 배치된 궁수마다
				int min = Integer.MAX_VALUE;
				int col = Integer.MAX_VALUE;

				for (int j = 0; j < tmp.size(); j++) { // 적을 탐색해서
					Position enemy = tmp.get(j);

					int distance = Math.abs(arrow.getRow() - enemy.getRow())
							+ Math.abs(arrow.getCol() - enemy.getCol());
					if (distance <= LIMIT) { // 적이 공격가능한 범위에 들어오면

						min = Math.min(min, distance); // 공격 가능한 범위에 있는 적들 중 가장 가까운 거리에 있는 적의 거리를 저장

						attackableEnemys.add(enemy);
					}

				}

				for (int j = 0; j < attackableEnemys.size(); j++) { // 공격 가능한 적을 탐색

					Position enemy = attackableEnemys.get(j); // 가장 위쪽의 값부터 순서대로 탐색

					int distance = Math.abs(arrow.getRow() - enemy.getRow())
							+ Math.abs(arrow.getCol() - enemy.getCol());

					if (distance == min) { // 최소거리에 있는 적 중 가장 왼쪽에 있는 적의 col좌표 저장

						col = Math.min(col, enemy.getCol());

					}

				}
				for (int j = 0; j < attackableEnemys.size(); j++) { // 공격 가능한 적을 탐색

					Position enemy = attackableEnemys.get(j); // 가장 위쪽의 값부터 순서대로 탐색

					int distance = Math.abs(arrow.getRow() - enemy.getRow())
							+ Math.abs(arrow.getCol() - enemy.getCol());

					if (distance == min && col == enemy.getCol()) { // 최소거리에 있는 적 중 가장 왼쪽에 있는 적의 col좌표 저장
						if (removeEnemys.indexOf(enemy) == -1) { // 공격 대상에 해당 적이 없으면

							removeEnemys.add(enemy);
							break;
						}

					}
				}

			}

			for (int i = 0; i < removeEnemys.size(); i++) { // 적을 제거한 경우
				tmp.remove(tmp.indexOf(removeEnemys.get(i)));
				count++; // 제거한 적의 수를 증가
			}

			for (int j = 0; j < tmp.size(); j++) { // 적의 좌표를 한칸씩 증가

				Position p = tmp.get(j);
				p.setRow(p.getRow() + 1); // row좌표 증가

				if (tmp.get(j).getRow() > N) { // 맵을 넘어가면
					tmp.remove(j--);
				}

			}

		}

		return count;
	}

}
