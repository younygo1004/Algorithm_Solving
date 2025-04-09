package 고득점_Kit.해시.전화번호_목록;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public boolean solution(String[] phone_book) {

        Arrays.sort(phone_book);

        Map<String, Integer> phoneMap = new HashMap<>();

        for (String phone : phone_book) {

            for (int i = 1; i <= phone.length()-1; i++) {
                if (phoneMap.containsKey(phone.substring(0, i))) {
                    return false;
                }
            }

            phoneMap.put(phone, 0); // 전화번호를 맵에 저장

        }

        return true;
    }

}
