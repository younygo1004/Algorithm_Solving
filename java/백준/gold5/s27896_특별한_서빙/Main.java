import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 학생 수
        int M = Integer.parseInt(st.nextToken()); // 폭동 일으키는 불만도
        st = new StringTokenizer(br.readLine());

        int sum = 0; // 쌓인 불만도 배열
        int count = 0; // 가지 갯수 카운터
        int hate; // 불만도
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < N; i++) {
            hate = Integer.parseInt(st.nextToken()); // 각 학생의 만족도
            sum += hate; // 불만족도 저장
            maxPQ.add(hate);
            if (sum >= M) {
                count++; // 가지를 주지 않으면 폭동 일어남
                sum -= maxPQ.poll()*2; // 이미 소고기를 줬다고 가정했기 때문에, max값의 2배를 뺌
            }
        }

        System.out.println(count);

    }
}
