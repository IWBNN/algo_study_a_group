import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        // dp[i] = i를 1로 만들기 위한 최소 연산 횟수
        int[] dp = new int[n + 1];
        
        // 상향식으로 최소 연산 횟수 계산
        for(int i = 2; i <= n; i++) {
            // 1을 빼는 경우
            dp[i] = dp[i-1] + 1;
            
            // 2로 나누어 떨어지는 경우
            if(i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i/2] + 1);
            }
            
            // 3으로 나누어 떨어지는 경우
            if(i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i/3] + 1);
            }
        }
        
        System.out.println(dp[n]);
    }
}