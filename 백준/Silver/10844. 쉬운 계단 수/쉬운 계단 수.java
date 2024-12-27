import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // dp[자릿수][마지막 숫자] = 경우의 수
        long[][] dp = new long[N + 1][10];

        // 한 자리 수 초기화 (0은 시작수가 될 수 없음)
        for(int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }

        // 두 자리 수부터 N자리 수까지
        for(int i = 2; i <= N; i++) {
            for(int j = 0; j <= 9; j++) {
                // 마지막 숫자가 0인 경우 -> 다음 숫자는 1만 가능
                if(j == 0) {
                    dp[i][j] = dp[i-1][1] % 1000000000;
                }
                // 마지막 숫자가 9인 경우 -> 다음 숫자는 8만 가능
                else if(j == 9) {
                    dp[i][j] = dp[i-1][8] % 1000000000;
                }
                // 그 외의 경우 -> 이전 숫자의 +-1이 가능
                else {
                    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % 1000000000;
                }
            }
        }

        // 각 자리의 경우의 수 합산
        long result = 0;
        for(int i = 0; i <= 9; i++) {
            result = (result + dp[N][i]) % 1000000000;
        }

        System.out.println(result);
    }
}