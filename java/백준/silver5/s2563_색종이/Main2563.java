package bj.silver5.s2563_색종이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import bj.BJ;


public class Main2563 {
	
	static final int LEN = 100;
	
	public static void main(String[] args) throws IOException {
		System.setIn(BJ.f(2563));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int cnt = Integer.parseInt(br.readLine());
		int ans= 0;
		boolean[][] paper = new boolean[LEN+1][LEN+1];
		int x, y;
		
		
		StringTokenizer st;
				
		for (int i = 0; i < cnt; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			
			for (int j = 100-y-10; j < 100-y; j++) {
				for (int k = x; k < x+10; k++) {
					paper[j][k] = true;
				}
			}
		}
		
		for (int i = 0; i < paper.length; i++) {
			for (int j = 0; j < paper[i].length; j++) {
				if(paper[i][j] == true) ans++;
			}
		}
		
		System.out.println(ans);
		
		br.close();
		
		
	}

}
