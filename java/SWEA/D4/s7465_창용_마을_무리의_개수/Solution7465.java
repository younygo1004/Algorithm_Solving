package swea.D4.s7465_창용_마을_무리의_개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution7465 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int cnt = 0;
			int[] humans = makeSet(num);

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());

				union(humans, from, to);
			}

			boolean[] leaders = new boolean[num + 1];

			for (int i = 1; i < humans.length; i++) {
				int leader = find(humans, i);
				leaders[leader] = true;
			}
			
			
			for (int i = 1; i < leaders.length; i++) {
				if (leaders[i])
					cnt++;
			}

			System.out.printf("#%d %d\n", tc, cnt);
		}

		br.close();

	}

	/**
	 * num 크기 만큼의 서로소 집합을 만드는 method
	 * 
	 * @param num 만들 서로소 집합의 개수
	 * @return num 크기의 서로소 집합을 표현하는 배열
	 */
	private static int[] makeSet(int num) {

		int[] arr = new int[num + 1];
		for (int i = 1; i < arr.length; i++) {
			arr[i] = i;
		}

		return arr;
	}

	/**
	 * 서로소 집합을 표현하고 있는 배열과 인덱스를 받아 해당 집합의 대표자를 반환하는 method
	 * 
	 * @param arr 서로소 집합을 표현하고 있는 배열
	 * @param idx 대표자를 알고자 하는 집합의 인덱스
	 * @return 받은 인덱스의 대표자가 누구인지 반환
	 */
	private static int find(int[] arr, int idx) {
		if (arr[idx] == idx)
			return idx;
		return arr[idx] = find(arr, arr[idx]);
	}

	/**
	 * 서로소 집합을 표현하고 있는 배열의 인덱스 2개를 받아, 두 집합이 서로소이면 하나의 집합으로 만드는 method
	 * 
	 * @param arr  서로소 집합을 표현하고 있는 배열
	 * @param to   대표자가 될 집합의 인덱스
	 * @param from to에 합쳐질 집합의 인덱스
	 * @return 집합을 합쳤으면 true, 이미 같은 집합이면 false
	 */
	private static boolean union(int[] arr, int to, int from) {
		int toLeader = find(arr, to);
		int fromLeader = find(arr, from);

		if (toLeader == fromLeader)
			return false;
		arr[fromLeader] = toLeader;

		return true;

	}

}
