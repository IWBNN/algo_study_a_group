import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static long P, Q;
    static HashMap<Long, Long> dp = new HashMap<>();

    static long solve(long n) {
        if (n == 0) return 1;

        if (dp.containsKey(n)) {
            return dp.get(n);
        }

        long result = solve(n/P) + solve(n/Q);
        dp.put(n, result);

        return result;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        long N = Long.parseLong(st.nextToken());
        P = Long.parseLong(st.nextToken());
        Q = Long.parseLong(st.nextToken());

        System.out.println(solve(N));

    }
}
