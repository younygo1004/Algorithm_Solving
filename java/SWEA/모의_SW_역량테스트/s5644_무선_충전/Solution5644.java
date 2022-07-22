package swea.모의_SW_역량테스트.s5644_무선_충전;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Coordinate {
	int x;
	int y;

	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Coordinate [x 좌표: " + x + ", y 좌표: " + y + "]";
	}

}

class Battery extends Coordinate {
	int c;
	int p;

	public Battery(int x, int y, int c, int p) {
		super(x, y);
		this.c = c;
		this.p = p;
	}

	@Override
	public String toString() {
		return "Battery [충전 범위: " + c + ", 처리량: " + p + ", x: " + x + ", y: " + y + "]";
	}

}

public class Solution5644 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			int count = Integer.parseInt(st.nextToken()); // BC의 갯수

			int sum = 0; // 최대값의 합을 저장할 변수
			int maxA = 0; // UserA의 최대값 판별
			int maxB = 0; // UserB의 최대값 판별
			Coordinate userA = new Coordinate(1, 1); // 사용자 A 시작 좌표
			Coordinate userB = new Coordinate(10, 10); // 사용자 B 시작 좌표
			int[] timesA = new int[time + 1];
			int[] timesB = new int[time + 1];
			Battery[] batteries = new Battery[count];

			st = new StringTokenizer(br.readLine()); // 사용자 A 이동경로 배열
			for (int i = 1; i <= time; i++) {
				timesA[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine()); // 사용자 B 이동경로 배열
			for (int i = 1; i <= time; i++) {
				timesB[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < batteries.length; i++) { // BC 좌표 정보 입력
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int p = Integer.parseInt(st.nextToken());

				batteries[i] = new Battery(x, y, c, p);

			}

			// 시작할 때의 초기값 셋팅
			for (int i = 0; i < batteries.length; i++) { // userA의 초기 최대값 구하기
				if (isChargerable(userA, batteries[i])) {
					maxA = Math.max(maxA, batteries[i].p);
				}

			}
			sum += maxA; // 최대 충전값에 사용자 A의 시작위치 최대 충전량 저장

			for (int i = 0; i < batteries.length; i++) { // userB의 초기 최대값 구하기
				if (isChargerable(userB, batteries[i])) {
					maxB = Math.max(maxB, batteries[i].p);
				}

			}
			sum += maxB; // 최대 충전값에 사용자 B의 시작위치 최대 충전량 저장

			for (int t = 1; t <= time; t++) { // 이동하면서 배터리 충전
				maxA = 0;
				maxB = 0;
				ArrayList<Battery> batteriesA = new ArrayList<Battery>();
				ArrayList<Battery> batteriesB = new ArrayList<Battery>();
				moveUser(userA, timesA[t]);
				moveUser(userB, timesB[t]);

//				System.out.printf("userA : %d %d, userB : %d %d\n", userA.x, userA.y, userB.x, userB.y);

				for (int i = 0; i < batteries.length; i++) { // 사용가능한 배터리 충전소 목록
					if (isChargerable(userA, batteries[i]))
						batteriesA.add(batteries[i]);
					if (isChargerable(userB, batteries[i]))
						batteriesB.add(batteries[i]);
				}

				if (batteriesA.isEmpty()) { // 사용자 A가 충전할 수 없으면
					for (int i = 0; i < batteriesB.size(); i++) {
						maxB = Math.max(maxB, batteriesB.get(i).p); // 충전량의 합의 최대값은 그냥 B가 충전할 수 있는 곳중 최대값이다.
					}
				} else if (batteriesB.isEmpty()) { // 사용자 A는 충전할 수 있고, B는 충전할 수 없으면
					for (int i = 0; i < batteriesA.size(); i++) {
						maxA = Math.max(maxA, batteriesA.get(i).p); // 충전량의 합의 최대값은 A가 충전할 수 있는 곳 중 최대값이다.
					}
				} else { // 사용자 A, B 모두 충전 가능하면
					
					for (int i = 0; i < batteriesA.size(); i++) {
						for (int j = 0; j < batteriesB.size(); j++) {
							Battery userABattery = batteriesA.get(i);
							Battery userBBattery = batteriesB.get(j);
							if (userABattery.equals(userBBattery)) { // 같은 충전소인 경우
								if (maxA + maxB < userABattery.p) {
									maxA = userABattery.p / 2;
									maxB = userBBattery.p / 2;
								}
							} else { // 다른 충전소인 경우
								if (maxA + maxB < userABattery.p + userBBattery.p) {
									maxA = userABattery.p;
									maxB = userBBattery.p;
								}
							}
						}
					}

				}
				sum += maxA + maxB; // A와 B가 충전할수 있는 최대값을 누적
			}
			System.out.printf("#%d %d\n", tc, sum);
		}

		br.close();

	}

	/**
	 * 주어진 사용자를 명령어에 따라 이동시킴.
	 * 
	 * @param user 이동시킬 사용자
	 * @param i    명령어 값
	 */
	private static void moveUser(Coordinate user, int i) {
		if (i == 1)
			user.y = user.y - 1;
		else if (i == 2)
			user.x = user.x + 1;
		else if (i == 3)
			user.y = user.y + 1;
		else if (i == 4)
			user.x = user.x - 1;

	}

	/**
	 * 주어진 BC에서 충전이 가능한지에 대한 여부를 boolean값으로 판별하는 method
	 * 
	 * @param user    충전 가능 여부를 체크할 user 객체
	 * @param battery 충전 가능 여부를 체크할 battery 객체
	 * @return 충전 가능하면 true, 불가능하면 false 반환
	 */
	private static boolean isChargerable(Coordinate user, Battery battery) {

		if (Math.abs(user.x - battery.x) + Math.abs(user.y - battery.y) <= battery.c)
			return true;

		return false;
	}

}
