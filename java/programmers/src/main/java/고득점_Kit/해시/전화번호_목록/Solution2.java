package 고득점_Kit.해시.전화번호_목록;

import java.util.Arrays;

public class Solution2 {

    public boolean solution(String[] phone_book) {

        Arrays.sort(phone_book);

        for (int i = 1; i < phone_book.length; i++) {

            if (phone_book[i].startsWith(phone_book[i-1])) {
                return false;
            }

        }

        return true;

    }
}
