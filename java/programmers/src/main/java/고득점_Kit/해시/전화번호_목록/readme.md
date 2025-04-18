# 고득점_KIT/해시/전화번호_목록

### 풀이1
```java
Arrays.sort(phone_book);

Map<String, Integer> phoneMap = new HashMap<>();
```
먼저 전화번호를 오름차순 정렬한다. <br>
오름차순으로 Map에 먼저 데이터를 넣고 시작하지 않고, 반복문을 돌리면서 Map에 데이터를 넣기 위함. (더 작고 짧은 수가 앞으로 옴) <br>

```java
for (String phone : phone_book) {

    for (int i = 1; i <= phone.length()-1; i++) {
        if (phoneMap.containsKey(phone.substring(0, i))) {
            return false;
        }
    }

    phoneMap.put(phone, 0); // 전화번호를 맵에 저장

}
```
정렬된 전화번호를 순회하며 substring을 사용하며 숫자를 검사, 만약 자신을 제외한 자신의 부분이 key값으로 검색이 된다면 접두어인 경우가 있는 것이므로 false를 return <br>

그렇지 않은 경우는 모두 false를 return

---
### 풀이2
카테고리가 Hash이므로 Map을 이용해 풀이한 위의 방법과는 다르게, 정렬을 이용한 풀이 방법

```java
Arrays.sort(phone_book);

for (int i = 1; i < phone_book.length; i++) {

    if (phone_book[i].startsWith(phone_book[i-1])) {
        return false;
    }

}

return true;
```
정렬을 하는 경우, 들어온 숫자가 Integer 혹은 int형이 아닌 String 타입이므로, 정렬은 문자열의 정렬 방식으로 정렬됨. <br>
즉, 데이터가 [123, 124, 1234, 1244]의 방식으로 주어졌을 때, [123, 124, 1234, 1244]로 정렬되는 것이 아닌 [123, 1234, 124, 1244] 순으로 정렬됨. <br>

따라서 HashSet이나 HashMap등의 문제풀이에서 필요한 방식이 아닌, 자신의 바로 앞 문자열과만 비교해도 문제없이 접두어를 찾아낼 수 있음.