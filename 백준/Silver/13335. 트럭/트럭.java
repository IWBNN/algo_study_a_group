import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, w ,L;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 트럭 수
        w = Integer.parseInt(st.nextToken()); // 다리 길이
        L = Integer.parseInt(st.nextToken()); // 최대 하중

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(passTime(n, w, L));
    }

    static int passTime(int n, int w, int L) {
        int time = 0;
        Queue<Integer> bridge = new LinkedList<>();

        // 다리를 빈 공간으로 초기화
        for (int i = 0; i < w; i++) {
            bridge.add(0);
        }

        int truckIndex = 0;  // 현재 대기 중인 트럭 인덱스
        int currentWeight = 0;  // 현재 다리 위 트럭 무게 합

        // 모든 트럭이 다리를 완전히 건널 때까지
        while (truckIndex < n || currentWeight > 0) {
            // 시간 증가
            time++;

            // 다리 맨 앞의 트럭(또는 빈 공간)이 다리를 빠져나감
            currentWeight -= bridge.poll();

            // 대기 중인 트럭이 남아있다면
            if (truckIndex < n) {
                // 다음 트럭이 다리에 올라갈 수 있는지 확인
                if (currentWeight + arr[truckIndex] <= L) {
                    // 트럭을 다리에 올림
                    bridge.add(arr[truckIndex]);
                    currentWeight += arr[truckIndex];
                    truckIndex++;
                } else {
                    // 무게 제한으로 다음 트럭이 올라갈 수 없으면 빈 공간 추가
                    bridge.add(0);
                }
            } else {
                // 더 이상 올릴 트럭이 없으면 빈 공간 추가
                bridge.add(0);
            }
        }

        return time;
    }
}
