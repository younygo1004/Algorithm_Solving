### 고득점_KIT_베스트앨범

----
```java
Map<String, Integer> genreMap = new HashMap<>();
Map<String, Map<Integer, Integer>> songsMap = new HashMap<>();
```
genreMap : 장르별 총 재생횟수를 저장하기 위한 Map 정의 <br>
songsMap : 노래를 장르별로 저장하기 위한 Map 정의

```java
for (int i = 0; i < genres.length; i++) {
    String genre = genres[i];
    int play = plays[i];

    if (!genreMap.containsKey(genre)) { // 해당 장르의 재생횟수 정보가 없으면
        genreMap.put(genre, play);
    }
    else { // 이미 재생횟수 정보가 있으면
        genreMap.replace(genre, genreMap.get(genre) + play); // 총 재생횟수를 계산
    }

    if (!songsMap.containsKey(genre)) { // 해당 장르의 노래 정보가 없으면
        // 해당 장르의 노래 정보를 최초로 저장
        Map<Integer, Integer> songInfo = new HashMap<>();
        songInfo.put(i, play); 
        songsMap.put(genre, songInfo);
    }
    else { // 이미 해당 장르의 노래정보가 있으면
        songsMap.get(genre).put(i, play); // 해당 장르의 노래정보에 추가
    }

}
```
각각의 맵에 정보를 저장하는 구간. <br>
genreMap에는 장르 이름을 Key로, 그 장르의 재생횟수를 더한 값을 Value로 저장한다. <br>
songsMap에는 장르 이름을 Key로 저장하고, Value 값에는 "Key에는 해당 곡의 고유 번호를, Value에는 해당 곡의 재생횟수를 저장한 Map"을 저장한다. <br>

```java
List<Integer> bestAlbum = new ArrayList<>();


List<String> genreList = new ArrayList<>(genreMap.keySet()); // 중복되지 않은 genre 정보 가져오기

genreList.sort((genre1, genre2) -> genreMap.get(genre2).compareTo(genreMap.get(genre1))); // 내림차순 정렬

for (String genre : genreList) { // 가장 많이 재생된 장르부터 반복문 순회
    List<Integer> songsList = new ArrayList<>(songsMap.get(genre).keySet());
    Map<Integer, Integer> songInfo = songsMap.get(genre);

    songsList.sort((song1, song2) -> Integer.compare(songInfo.get(song2), songInfo.get(song1)));
    bestAlbum.add(songsList.get(0));

    if (songsList.size() >= 2) {
        bestAlbum.add(songsList.get(1));
    }

}
```

베스트앨범의 곡 순서를 저장할 List를 하나 정의한다. <br>

장르별 재생횟수를 담은 genreMap에서 중복되지 않은 genre 정보를 `genreMap.keySet()`으로 가져온다. <br>
또한 그 List를 genreMap에 있는 총 재생횟수 정보를 이용해 내림차순으로 정렬한다. <br>

정렬된 List를 순차적으로 돌면, 가장 많이 재생된 장르부터 값을 꺼내올 수 있다. <br>

```java
// 해당 장르의 곡 고유번호 정보를 List로 가져오기
List<Integer> songsList = new ArrayList<>(songsMap.get(genre).keySet()); 

// songsMap에 저장된 Value 값, 즉 곡의 고유번호와 재생횟수를 가지고 있는 Map을 가져온다.
Map<Integer, Integer> songInfo = songsMap.get(genre); 
```
그 후, 해당 장르의 곡 고유번호 목록을 List로 가져온다. <br>
그리고 고유번호 별 재생횟수를 가지고 있는 songsMap의 Value값을 가져온다. <br>

```java
// 고유번호 List를 내림차순 정렬을 통해, 그 장르에서 가장 많이 재생된 순으로 정렬한다.
songsList.sort((song1, song2) -> Integer.compare(songInfo.get(song2), songInfo.get(song1)));
```

곡의 고유번호를 내림차순을 통해 가장 많이 재생된 순서대로 정렬한다.

```java
bestAlbum.add(songsList.get(0));

if (songsList.size() >= 2) {
    bestAlbum.add(songsList.get(1));
}
```

정렬 후, 가장 앞에서부터 최대 2개의 값만 추출하여 베스트 앨범에 저장한다.

```java
public int[] solution(String[] genres, int[] plays)
```

```java
return bestAlbum.stream().mapToInt(Integer::intValue).toArray();
```

마지막으로 해당 List를 return한다. solution의 return type이 `int[]`이므로, List를 int[] type으로 변경해주어야 한다.