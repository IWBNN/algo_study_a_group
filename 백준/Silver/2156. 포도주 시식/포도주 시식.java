import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] wine = new int[n + 1];
        int[] dp = new int[n + 1];

        for(int i = 1; i <= n; i++) {
            wine[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = wine[1];
        
        if(n >= 2) {
            dp[2] = wine[1] + wine[2];
        }

        for(int i = 3; i <= n; i++) {
            // 세 가지 경우 중 최댓값을 선택
            dp[i] = Math.max(dp[i-1],  // 현재 포도주를 마시지 않는 경우
                    Math.max(dp[i-2] + wine[i],  // 이전 포도주를 마시지 않고 현재 포도주를 마시는 경우
                            dp[i-3] + wine[i-1] + wine[i]));  // 이전 포도주와 현재 포도주를 마시는 경우
        }

        System.out.println(dp[n]);
    }
}