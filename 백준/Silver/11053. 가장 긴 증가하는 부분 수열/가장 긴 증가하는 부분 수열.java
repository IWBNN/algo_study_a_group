import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];  // dp[i]: i번째 원소를 마지막으로 하는 최장 증가 부분 수열의 길이

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 모든 원소의 기본 길이는 1
        for (int i = 0; i < N; i++) {
            dp[i] = 1;
        }

        // 각 위치마다 이전 원소들을 확인
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {  // 현재 수가 이전 수보다 크다면
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        // 최대 길이 찾기
        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}