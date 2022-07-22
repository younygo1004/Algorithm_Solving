package bj.silver5.s1158_요세푸스_문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main1158 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		LinkedList<Integer> lst = new LinkedList<>();
		LinkedList<Integer> ans = new LinkedList<>();
		
		for (int i = 1; i <= N; i++) {
			lst.add(i);
		}
		
		int idx = 0;
		while(!lst.isEmpty()){
			
			idx = (idx + K-1) % (lst.size());
			
			ans.add(lst.get(idx));
			lst.remove(idx);
			
			
			
			
		}
		
		System.out.println(ans.toString().replaceAll("\\[", "<").replaceAll("\\]", ">"));
		
		
		br.close();
	}

}
