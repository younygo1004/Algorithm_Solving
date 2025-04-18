package 고득점_Kit.해시.베스트앨범;

import java.util.*;

public class Solution {

    public int[] solution(String[] genres, int[] plays) {

        /* 장르와 재생횟수, 고유번호를 저장하기 위한 맵 정의
         * 1. Map<String, Integer> genreMap : 노래의 장르(Key), 이름에 해당하는 총 재생횟수(Value) 저장
         * 2. Map<String, Map<Integer, Integer>> : 노래의 장르(Key), 해당 노래의 고유 번호(Value의 Key), 재생횟수(Value의 Value) 저장
         */
        Map<String, Integer> genreMap = new HashMap<>();
        Map<String, Map<Integer, Integer>> songsMap = new HashMap<>();

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

        // 출시할 베스트 앨범 정보를 저장할 List
        List<Integer> bestAlbum = new ArrayList<>();


        List<String> genreList = new ArrayList<>(genreMap.keySet()); // 중복되지 않은 genre 정보 가져오기

        genreList.sort((genre1, genre2) -> genreMap.get(genre2).compareTo(genreMap.get(genre1))); // 내림차순 정렬

        for (String genre : genreList) { // 가장 많이 재생된 장르부터 반복문 순회

            // 해당 장르의 곡 고유번호 정보를 List로 가져오기
            List<Integer> songsList = new ArrayList<>(songsMap.get(genre).keySet());

            // songsMap에 저장된 Value 값, 즉 곡의 고유번호와 재생횟수를 가지고 있는 Map을 가져온다.
            Map<Integer, Integer> songInfo = songsMap.get(genre);

            // 고유번호 List를 내림차순 정렬을 통해, 그 장르에서 가장 많이 재생된 순으로 정렬한다.
            songsList.sort((song1, song2) -> Integer.compare(songInfo.get(song2), songInfo.get(song1)));
            bestAlbum.add(songsList.get(0));

            if (songsList.size() >= 2) {
                bestAlbum.add(songsList.get(1));
            }

        }


        return bestAlbum.stream().mapToInt(Integer::intValue).toArray();
    }

}
