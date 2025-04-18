package 고득점_Kit.해시.의상;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int solution(String[][] clothes) {

        // 옷 종류별 개수를 세기 위한 Map 정의
        Map<String, Integer> clothesMap = new HashMap<>();

        // 옷의 종류별로 개수를 세기 위해 반목문 순회
        for (String[] clothe : clothes){

            // 옷의 종류별로 숫자를 세는 과정
            if (!clothesMap.containsKey(clothe[1])) {
                clothesMap.put(clothe[1], 0);
            }
            else {
                clothesMap.replace(clothe[1], clothesMap.get(clothe[1]) + 1);
            }

        }

        
        int answer = 1;
        
        // 옷의 종류별 개수를 곱하면 옷을 입는 방법의 개수가 나옴
        for (int num : clothesMap.values()) {
            answer *= num;
        }

        // 아무 옷도 입지 않는 1개의 경우의 수를 빼서 return
        return answer - 1;

    }


}
