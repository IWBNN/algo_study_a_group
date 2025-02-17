import java.io.*;
import java.util.*;

public class Main {
    static long[][] dp = new long[30][30];
    
    public static long combination(int n, int r) {
        // 이미 계산된 값이라면 바로 반환
        if(dp[n][r] > 0) {
            return dp[n][r];
        }
        
        // 조합의 성질 활용
        if(r == 0 || n == r) {
            return dp[n][r] = 1;
        }
        
        // 파스칼의 삼각형 성질 활용
        return dp[n][r] = combination(n-1, r-1) + combination(n-1, r);
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            
            System.out.println(combination(M, N));
        }
    }
}