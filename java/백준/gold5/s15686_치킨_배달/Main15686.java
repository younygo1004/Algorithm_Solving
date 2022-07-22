package bj.gold5.s15686_치킨_배달;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class CityInfo {
	private int row;
	private int col;

	public CityInfo(int row, int col) {
		super();
		this.row = row;
		this.col = col;
	}

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

}

public class Main15686 {
	static int MIN = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 도시 크기
		int M = Integer.parseInt(st.nextToken()); // 타노스하고 남은 치킨집 갯수
		ArrayList<CityInfo> chicken = new ArrayList<>();
		ArrayList<CityInfo> house = new ArrayList<>();

		for (int row = 1; row <= N; row++) { // 도시의 집, 치킨집 좌표 입력받기
			st = new StringTokenizer(br.readLine());

			for (int col = 1; col <= N; col++) {
				String s = st.nextToken();
				if (s.equals("1")) {
					house.add(new CityInfo(row, col));
				} else if (s.equals("2")) {
					chicken.add(new CityInfo(row, col));
				}
			}
		}

		combinationChicken(house, chicken, new CityInfo[M], 0, 0);
		
		System.out.println(MIN);

		br.close();

	}
	
	/**
	 * 모든 치킨집중 넘겨받은 CityInfo 배열의 갯수만큼 선택해서 도시의 치킨 거리의 최소값을 찾는 recursive method
	 * @param house			치킨거리 계산을 위한 집의 좌표가 담겨있는 ArrayList
	 * @param chicken		치킨거리 계산을 위한 치킨집의 좌표가 담겨있는 ArrayList
	 * @param selChicken	치킨집 중에서 citiInfos 배열의 크기만큼 치킨집을 조합으로 선택하기 위한 배열
	 * @param idx			치킨집 배열 순회를 위한 인덱스
	 * @param k				cityInfos 배열에 값을 저장하기 위한 인덱스
	 */
	private static void combinationChicken(ArrayList<CityInfo> house, ArrayList<CityInfo> chicken, CityInfo[] selChicken, int idx, int k) {
		
		if(k == selChicken.length) { // M개의 치킨집을 다 고르면
			
			// 각 집에서의 치킨거리 합이 도시의 치킨 거리이므로, 각 집에서의 치킨 거리의 합을 구한 다음 min값과 비교한다.
			int distance = getChickenDistance(house, selChicken);
			
			MIN = Math.min(MIN, distance);
			
			return;
		}
		
		if(idx == chicken.size()) { // 치킨집 배열을 다 보면
			return;
		}
		
		// 조합을 뽑아낸다.
		for (int i = idx; i < chicken.size(); i++) {
			selChicken[k] = chicken.get(i);
			
			combinationChicken(house, chicken, selChicken, i+1, k+1);
			
		}
		
	}

	/**
	 * 도시의 치킨거리를 구하는 method
	 * @param house		집의 좌표 배열
	 * @param chicken	치킨집의 좌표 배열
	 * @return			도시의 치킨 거리
	 */
	private static int getChickenDistance(ArrayList<CityInfo> house, CityInfo[] chicken) {
		int ans = 0;
		
		for (int i = 0; i < house.size(); i++) { // 모든 집에서
			int distance = Integer.MAX_VALUE;
			for (int j = 0; j < chicken.length; j++) { //모든 치킨집을 가본다.
				int tmp = Math.abs(house.get(i).getRow() - chicken[j].getRow()) + Math.abs(house.get(i).getCol() - chicken[j].getCol());
				
				distance = Math.min(distance, tmp);
			}
			ans += distance;
			
		}
		
		return ans;
	}

}
