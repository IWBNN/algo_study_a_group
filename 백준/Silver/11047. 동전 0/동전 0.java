import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N과 K 입력 받기
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 동전의 가치를 저장할 배열
        int[] coins = new int[N];

        // N개의 동전 가치 입력 받기
        for(int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;  // 필요한 동전의 개수

        // 큰 동전부터 처리하기 위해 뒤에서부터 순회
        for(int i = N-1; i >= 0; i--) {
            if(K >= coins[i]) {  // 현재 동전으로 만들 수 있는 경우
                count += K / coins[i];  // 해당 동전으로 만들 수 있는 최대 개수를 더함
                K %= coins[i];  // 남은 금액 계산
            }

            if(K == 0) {  // 금액을 모두 만든 경우
                break;
            }
        }

        System.out.println(count);
    }
}