package 고득점_Kit.스택and큐.같은_숫자는_싫어;

import java.util.*;

public class Solution {
    public int[] solution(int []arr) {

        // Deque를 이용하여 Stack과 Queue의 기능을 모두 사용
        Deque<Integer> answer = new ArrayDeque<>();
        answer.offer(arr[0]);

        for (int num : arr) {
            // 마지막 요소와 비교 후, 요소는 순서대로 넣는다
            if (answer.peekLast() != null && answer.peekLast() != num) {
                answer.offer(num);
            }
        }

        // Deque<Integer> -> int[] 변환 후 return
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

}
