package 고득점_Kit.해시.의상;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int solution(String[][] clothes) {

        Map<String, Integer> clothesMap = new HashMap<>();

        for (String[] clothe : clothes){

            if (!clothesMap.containsKey(clothe[1])) {
                clothesMap.put(clothe[1], 0);
            }
            else {
                clothesMap.replace(clothe[1], clothesMap.get(clothe[1]) + 1);
            }

        }

        int answer = 1;

        for (int num : clothesMap.values()) {
            answer *= num;
        }


        return answer - 1;

    }


}
