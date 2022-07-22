package bj.silver5.s2477_참외밭;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import bj.BJ;

public class Main2477 {

	public static void main(String[] args) throws IOException {
		System.setIn(BJ.f(2477));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int kMelon = Integer.parseInt(br.readLine());
		int[][] parm = new int[6][2];
		int[] counts = new int[5];
		int bigSqure = 1;
		int smallSqure = 1;
		int area;
		
		for (int i = 0; i < 6; i++) {
			String[] strs = br.readLine().split(" ");
			
			
			parm[i][0] = Integer.parseInt(strs[0]);
			parm[i][1] = Integer.parseInt(strs[1]);
			
			counts[parm[i][0]]++;
			
		}
		for (int i = 0; i < 6; i++) {
			
			if(counts[parm[i][0]] == 1) {
				bigSqure *= parm[i][1];
				smallSqure *= parm[(i+3)%6][1];
			}
			
		}
		
		area = bigSqure - smallSqure;
		
		System.out.println(area*kMelon);
		
		
		
		
		
	}

}
