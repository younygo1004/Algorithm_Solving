# SWEA. 1288. 새로운 불면증 치료법

### 풀이 방법 <br>


1. 1~10까지의 숫자가 나왔는지 셀 리스트를 미리 만들어 둔다.
2. 다음으로 x*N을 구한 후, 문자열로 치환한다.
3. 해당 문자열을 리스트로 변환해 쪼갠다.
4. 쪼개진 문자들을 다시 숫자로 변환한다.
5. 4번에서 변환한 숫자를 인덱스로 지정하여, num_check_list의 해당 인덱스를 1로 변경한다.
6. 만약 num_check_list의 합이 10이 되면, 모든 숫자를 본 것이다.
7. x*N을 출력한다.