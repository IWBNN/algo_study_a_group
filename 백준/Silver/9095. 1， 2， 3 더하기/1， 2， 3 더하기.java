import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int T;
    static int[] testCase;
    static int[] dp;
    static int[] count;

    public static void main(String[] args) throws IOException {
        // long startTime = System.nanoTime();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        testCase = new int[T];
        count = new int[T];

        dp = new int[12];

        dp[1] = 1; // 1
        dp[2] = 2; // 1+1, 2
        dp[3] = 4; // 1+1+1, 1+2, 2+1, 3

        for (int j = 4; j <= 11; j++) {
            //if (dp[j] == 0) {
            dp[j] = dp[j-1] + dp[j-2] + dp[j-3];
            //}
        }
        
        for (int i = 0; i < T; i++) {
            testCase[i] = Integer.parseInt(br.readLine());

            count[i] = dp[testCase[i]];
        }
        for (int w = 0; w < count.length; w++) {
            System.out.println(count[w]);
        }

        // long endTime = System.nanoTime();
        // System.out.println("실행 시간: " + (endTime - startTime) / 1000000.0 + "ms");
    }
}
