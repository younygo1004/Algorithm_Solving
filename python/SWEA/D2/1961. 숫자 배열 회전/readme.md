# SWEA. 1961. 숫자 배열 회전

### 풀이 방법 <br>

1. 원본 숫자 배열을 2차원 리스트 형태로 입력받는다.
2. 원본 배열을 90도 돌린 후, 변수에 저장해 둔다.
3. 2번에서 얻은 배열을 다시 90도 돌리면, 180도 배열을 얻을 수 있다. 변수에 저장해 둔다.
4. 3번에서 저장한 배열을 다시 90도 돌리면, 270도 배열을 얻을 수 있다. 변수에 저장해 둔다.
5. for문을 통해 2~4번의 1번 열부터 마지막 열까지 순서대로 출력한다.
