package 고득점_Kit.해시.폰켓몬;

import java.util.Arrays;

class Solution {
    public int solution(int[] nums) {

        return Math.min(nums.length/2, Arrays.stream(nums).distinct().toArray().length);
    }
}
