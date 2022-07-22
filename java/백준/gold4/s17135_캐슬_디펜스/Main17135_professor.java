package bj.gold4.s17135_캐슬_디펜스;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


/*
 *  |r1-r2| + |c1-c2|
 */
public class Main17135_professor {
	static int N, M, K, Ans=0;
	static int[] archors;
	static ArrayList<Enemy> enemys;
	static class Enemy {
		int r,c;
		Enemy(int r,int c){
			this.r=r;
			this.c=c;
		}
		@Override
		public String toString() {
			return "Emery [r=" + r + ", c=" + c + "]";
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException {

		System.setIn(new FileInputStream("캐슬디펜스.txt"));
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		enemys = new ArrayList<>();
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if(sc.nextInt()==1) {
					enemys.add(new Enemy(r, c));
				}
			}
		}
		archors = new int[3];
		combination(archors, 0, 0);
		
		System.out.println(Ans);
	}
	
	private static void combination(int[] archors, int idx, int sel) {
		
		if (sel == archors.length) {
			// 여기서부터 문제 풀기 시작
			// map 복사
			ArrayList<Enemy> tmp = new ArrayList();
			for (Enemy e : enemys) {
				tmp.add(new Enemy(e.r, e.c));
			}
			// tmp에 적이 없어질때 까지 loop
			int cnt=0;
			while(tmp.size()!=0) {
				ArrayList<Enemy>blackList = new ArrayList();
				for (int archor : archors) {
					int enemy = findEnemy(tmp, archor);
					if(enemy!=-1) {
						blackList.add(tmp.get(enemy));
					}
				}
				for (Enemy enemy : blackList) {
					if(tmp.remove(enemy)) {
						cnt++;
					}
				}
				mapMove(tmp);
			}
			Ans = Math.max(Ans, cnt);
			
			return;
		}

		if (idx == M) {
			return;
		}
		archors[sel]=idx;
		combination(archors, idx+1, sel+1);
		combination(archors, idx+1, sel);
		
	}

	private static int findEnemy(ArrayList<Enemy> tmp, int sel) {
		int minIdx=-1;
		int minDD = Integer.MAX_VALUE;
		for (int i = 0; i < tmp.size(); i++) {
			Enemy e = tmp.get(i);
			//|r1-r2| + |c1-c2| enemy 찾기
			
			int dd = Math.abs(N-e.r) + Math.abs(sel-e.c);

			if(dd <= K) {
				//System.out.println(i);
				if(minDD > dd) {
					minDD = dd;
					minIdx=i;
				}else if(minDD==dd) {
					if(e.c < sel) {
						minDD=dd;
						minIdx=i;
					}
				}
				
			}
		}
		return minIdx;
	}
	private static void mapMove(ArrayList<Enemy> tmp) {
		//print(tmp);
		for (int i = 0; i < tmp.size(); i++) {
			tmp.get(i).r++;
			if(tmp.get(i).r == N) {
				//System.out.println(1111);
				tmp.remove(tmp.get(i));
				i--;
			}
		}
	}
	
	static void print(ArrayList<Enemy> tmp){
		int cnt=0;
		for (Enemy e : tmp) {
			System.out.println(e.toString());
			cnt++;
		}
		System.out.println(cnt);
	}
	
	

}
