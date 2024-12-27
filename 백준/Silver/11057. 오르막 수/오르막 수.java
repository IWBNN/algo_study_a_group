import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[][] dp = new long[N+1][10];

        for (int i = 0; i <= 9; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j == 9) {
                    // 마지막 숫자가 9인 경우 9만 가능
                    dp[i][j] = dp[i-1][j] % 10007;
                } else {
                    for (int w = j; w <= 9; w++) {
                        dp[i][j] += dp[i-1][w] % 10007;
                    }
                }
            }
        }

        // 각 자리의 경우의 수 합산
        long result = 0;
        for(int i = 0; i <= 9; i++) {
            result = (result + dp[N][i]) % 10007;
        }

        System.out.println(result);
    }
}
