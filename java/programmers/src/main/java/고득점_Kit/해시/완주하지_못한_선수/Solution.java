package 고득점_Kit.해시.완주하지_못한_선수;

import java.util.*;
import java.util.Arrays.*;
import java.util.stream.*;
import java.util.function.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> completionMap = Arrays.stream(completion)
                .collect(Collectors.toMap(name -> name, name -> 1, (old, newV) -> old+1));

        for (String name : participant) {
            if (!completionMap.containsKey(name)) { // 명단에 없는 경우
                return name;
            }
            else {
                completionMap.replace(name, completionMap.get(name) - 1);

                if (completionMap.get(name) < 0) { // 동명이인인 경우
                    return name;
                }
            }
        }

        return "";
    }
}
