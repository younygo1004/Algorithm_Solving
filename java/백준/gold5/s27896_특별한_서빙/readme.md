## 백준_27896

```java
int sum = 0; // 쌓인 불만도 배열
        int count = 0; // 가지 갯수 카운터
        int hate; // 불만도
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
```

### 알고리즘

먼저 불만도를 판단하기 위해, 쌓인 불만도를 저장할 sum 변수를 0으로 초기화

그 후, 해당 학생의 만족도/불만족도를 받을 hate 변수 선언

PriorityQueue를 이용하여, 불만족도가 기준을 넘은 시점에서 가장 만족도 점수가 높은 학생 순으로 저장하기로 하였음.

```java
for (int i = 0; i < N; i++) {
            hate = Integer.parseInt(st.nextToken()); // 각 학생의 만족도
            sum += hate; // 불만족도 저장
            maxPQ.add(hate);
            if (sum >= M) {
                count++; // 가지를 주지 않으면 폭동 일어남
                sum -= maxPQ.poll()*2; // 이미 소고기를 줬다고 가정했기 때문에, max값의 2배를 뺌
            }
        }
```
일단은 모든 학생에게 파묻튀를 준 후, 불만족도 기준을 체크

만약 불만족도가 기준에 도달한 경우, 그때까지의 모든 학생 중에 만족도가 가장 큰 학생에게 가지를 줘야 한다는 결론이 나온다.

그런데 이미 파묻튀를 줬기 때문에, 해당 학생은 이미 불만족한 상태이므로, 만족도*2를 빼 줘야 정확한 값이 나온다.
