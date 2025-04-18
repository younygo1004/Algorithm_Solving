package 고득점_Kit.해시.완주하지_못한_선수;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

class Solution {
    public String solution(String[] participant, String[] completion) {

        // 완주한 선수의 이름을 Key로, Value를 1로, 동명이인인 경우 Value값을 +1로 저장하는 Map 정의
        Map<String, Integer> completionMap = Arrays.stream(completion)
                .collect(Collectors.toMap(name -> name, name -> 1, (old, newV) -> old+1));

        // 참여한 선수들의 명단을 완주한 선수 명단과 비교하기 위한 반복문
        for (String name : participant) {
            if (!completionMap.containsKey(name)) { // 명단에 없는 경우
                return name; // 완주하지 못한 선수의 이름을 return
            }
            else { // 명단에 있는 경우
                // 완주한 선수 명단에서 숫자를 1씩 빼서 확인
                completionMap.replace(name, completionMap.get(name) - 1);

                // -1이면 명단을 중복 확인한 것이나 마찬가지, 즉 동명이인인 경우가 이에 해당
                if (completionMap.get(name) < 0) {
                    return name; // 동명이인인 선수의 이름을 return
                }
            }
        }

        return "";
    }
}
