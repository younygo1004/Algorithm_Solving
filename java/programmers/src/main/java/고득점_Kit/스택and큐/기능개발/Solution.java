package 고득점_Kit.스택and큐.기능개발;

import java.util.*;

class Solution {

    public int[] solution(int[] progresses, int[] speeds) {

        Queue<Integer> days = new LinkedList<>();

        // 배포까지 필요한 날짜를 미리 계산
        for (int i = 0; i < progresses.length; i++) {
            int day = (int) Math.ceil((double) (100 - progresses[i]) / speeds[i]);
            days.offer(day);
        }

        // 배포 시점마다 배포 가능한 개수를 저장할 List (해당 문제의 답안을 저장)
        List<Integer> answer = new ArrayList<>();
        while (!days.isEmpty()) {

            // 가장 앞에 있는 기능을 배포
            int day = days.poll();
            int num = 1;

            // 배포 시점에 같이 배포 가능한 기능 찾기
            while (days.peek() != null && days.peek() <= day) {
                days.poll(); // 해당 기능도 같이 배포
                num++; // 한번에 배포하는 기능 개수 세기
            }
            answer.add(num); // 배포 시점에 한번에 배포하는 기능 개수 저장

        }


        // List<Integer> -> int[] 변환 후 반환
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}