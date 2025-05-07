package 고득점_Kit.스택and큐.올바른_괄호;

import java.util.*;

class Solution {
    boolean solution(String s) {

        // 괄호 문자열을 괄호 문자 배열로 변환
        char[] cs = s.toCharArray();

        // 첫 번째 괄호가 ')' 인 경우 false
        if (cs[0] ==')') {
            return false;
        }

        // 올바른 괄호인지 체크하기 위한 Deque(Stack)
        Deque<Character> check = new ArrayDeque<>();

        // 괄호 문자 배열 탐색
        for (char c : cs) {

            // 여는 괄호는 Stack에 저장
            if (c == '(') {
                check.push(c);
            }
            // 닫는 괄호는 여는 괄호와 짝지어져 있는지 체크해야 함
            else if(c ==')') {

                // 여는 괄호가 남아있지 않은 경우, 잘못된 괄호임 (닫는 괄호가 여는 괄호 앞에 나오는 경우의 수 포함)
                if (check.isEmpty()) {
                    return false;
                }
                // 여는 괄호가 남아 있는 경우, 닫는 괄호와 함께 하나씩 소각
                check.pop();
            }

        }

        // 만약 check가 비어있으면 알맞게 짝지어진 괄호이므로 true를 반환, 아닌 경우는 false 반환
        return check.isEmpty();
    }
}
