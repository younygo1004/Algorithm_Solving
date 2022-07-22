package bj.bronze1.s2839_설탕_배달;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2839_DP {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int kilo = Integer.parseInt(br.readLine());
		
		
		int ans = get_num(kilo);
		
		System.out.println(ans);
		
		br.close();
		

	}

	private static int get_num(int kilo) {
		
		if(kilo == 3 || kilo == 5)
			return 1;
		
		if(kilo == 4)
			return -1;
		
		int[] nums = new int[kilo+1];
		
		nums[1] = nums[2] = nums[4] = -1;
		nums[3] = nums[5] = 1;
		
		for (int i = 6; i <= kilo; i++) {
			if(nums[i-5] == -1 && nums[i-3] != -1) {
				nums[i] = nums[i-3]+1;
			}
			else if(nums[i-5] != -1 && nums[i-3] == -1) {
				nums[i] = nums[i-5]+1;
			}
			else if(nums[i-5] == -1 && nums[i-3] == -1) {
				nums[i] = -1;
			}
			else if(nums[i-5] != -1 && nums[i-3] != -1) {
				nums[i] = Math.min(nums[i-3]+1, nums[i-5]+1);
			}
			
		}
		
		return nums[kilo];
	}

}
