package bj.gold5.s1759_암호_만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1759 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer	st = new StringTokenizer(br.readLine());
		
		int L = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		String[] strs = br.readLine().split(" ");
		
		Arrays.sort(strs);
		
		printAllPassWord(strs, new String[L], 0, 0);
		
		br.close();
	}

	private static void printAllPassWord(String[] arr, String[] sel, int idx, int k) {
		
		if(k==sel.length) {	
			
			String check = "aeiou";
			boolean flag = false;
			int cnt = 0;
			
			for (int i = 0; i < sel.length; i++) {
				if(check.contains(sel[i])) {
					flag = true;
				}
				else 
					cnt++;
			}
			if(cnt >= 2 && flag) {
				for (int j = 0; j < sel.length; j++) {
					System.out.print(sel[j]);
				}
				System.out.println();
				
			}
			return;
		}
		
		for (int i = idx; i < arr.length; i++) {
			sel[k] = arr[i];
			printAllPassWord(arr, sel, i+1, k+1);
		}
	}

}
