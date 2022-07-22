package ssafy.im.solve.s1225_암호생성기;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 암호생성기 {
	static int T=10;
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("암호생성기.txt"));
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= T; tc++) {
			sc.nextInt();
			Queue<Integer> Q = new LinkedList<>();
			for (int i = 0; i < 8; i++) {
				Q.offer(sc.nextInt());
			}
			int minus=1;
			while(true) {
				int v = Q.poll()-minus;
				if(v <= 0) {
					v=0;
					Q.add(v);
					break;
				}else {
					Q.add(v);
				}
				minus++;
				if(minus==6) {
					minus=1;
				}
			}
			
			System.out.printf("#%d %s\n",tc,Q.toString().replaceAll("[\\[\\,\\]]", ""));
		}
	}
}
