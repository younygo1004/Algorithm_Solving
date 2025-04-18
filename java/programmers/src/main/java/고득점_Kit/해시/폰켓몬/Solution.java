package 고득점_Kit.해시.폰켓몬;

import java.util.Arrays;

class Solution {
    public int solution(int[] nums) {

        // 최대 N/2 마리의 포켓몬을 가져갈 수 있으니, nums.length/2를 최대값으로 설정, 그보다 작은 경우는 distinct 옵션을 통해 구하기
        return Math.min(nums.length/2, Arrays.stream(nums).distinct().toArray().length);
    }
}
