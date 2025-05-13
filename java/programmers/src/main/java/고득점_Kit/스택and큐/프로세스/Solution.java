package 고득점_Kit.스택and큐.프로세스;

import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {

        // 프로세스의 우선순위 값을 저장하는 Ready Queue
        Queue<Integer> readyQueue = new LinkedList<>();

        // Ready Queue에 저장된 프로세스의 배열 인덱스를 저장하는 Queue
        Queue<Integer> indexQueue = new LinkedList<>();

        // 가장 우선순위가 높은 값부터 순서대로 저장할 우선순위 큐
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());

        // 각 Queue에 데이터 입력
        for (int i = 0; i < priorities.length; i++) {
            int priority = priorities[i];
            int index = i;

            readyQueue.offer(priority);
            indexQueue.offer(index);
            priorityQueue.offer(priority);

        }

        // 프로세스의 실행순서 값
        int order = 1;
        
        // Ready Queue를 순회
        while (!readyQueue.isEmpty()) {
            
            // Ready Queue와 현재 index 값을 꺼내기
            int priority = readyQueue.poll();
            int index = indexQueue.poll();

            // 현재 프로세스가 가장 높은 우선순위를 가지는 경우
            if (priorityQueue.peek() == priority) {

                // 알고싶은 위치의 프로세스가 실행되는 경우
                if (index == location) {
                    // 프로세스의 실행 순서를 반환
                    return order;
                }
                
                // 현재 프로세스가 가장 높은 우선순위를 가지는 경우 프로세스 실행
                priorityQueue.poll();
                order++; // 다른 프로세스들의 실행 순서를 1단계 뒤로 미룸

            }
            else { // 현재 프로세스가 실행되지 않는 경우 다시 Ready Queue에 저장
                readyQueue.offer(priority);
                indexQueue.offer(index);

            }

        }

        // 해당 return 값은 정상적으로 실행되지 않았거나, 예외 상황이므로 -1을 반환 (오류 상황)
        return -1;
    }
}
