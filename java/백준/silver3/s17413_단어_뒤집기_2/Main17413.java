package bj.silver3.s17413_단어_뒤집기_2;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

import bj.BJ;

public class Main17413 {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(BJ.f(17413));
		Scanner sc = new Scanner(System.in);
		StringBuilder finalString = new StringBuilder();
		StringTokenizer	tagSplit = new StringTokenizer(sc.nextLine(), "<>", true);
		
		boolean isTag = false;
		
		
		
		while(tagSplit.hasMoreElements()) {
			
			String s = tagSplit.nextElement().toString();
			System.out.println(s);
			if(s.equals("<")) isTag = true;
			
			if(isTag) finalString.append(s);
			else {
				StringTokenizer st = new StringTokenizer(s, " ", true);
				StringBuilder reverse;
				while (st.hasMoreElements()) {
					System.out.println(st.nextElement());
					String rev = st.nextElement().toString();
					reverse = new StringBuilder(rev);
					finalString.append(reverse.reverse());
					
				}
			}
		
			if(s.equals(">")) isTag = false;
				
		}
		
		System.out.println(finalString);

		
		sc.close();

	}

}
