import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] stairs = new int[n + 1];  // 계단 점수 저장
        int[] dp = new int[n + 1];      // 각 계단까지의 최대 점수

        // 계단 점수 입력받기
        for(int i = 1; i <= n; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        // 초기값 설정
        dp[1] = stairs[1];

        if(n >= 2) {
            dp[2] = stairs[1] + stairs[2];
        }

        // 3번째 계단부터 계산
        for(int i = 3; i <= n; i++) {
            // 두 가지 경우 중 최댓값 선택
            // 1) 직전 계단을 밟은 경우: dp[i-3] + stairs[i-1] + stairs[i]
            // 2) 직전 계단을 밟지 않은 경우: dp[i-2] + stairs[i]
            dp[i] = Math.max(dp[i-3] + stairs[i-1] + stairs[i], dp[i-2] + stairs[i]);
        }

        System.out.println(dp[n]);
    }
}