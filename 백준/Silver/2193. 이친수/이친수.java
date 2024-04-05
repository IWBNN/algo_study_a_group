import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] sum = new long[N+1];

        sum[0] = 0;
        sum[1] = 1;

        for(int i = 2;i<N+1;i++){
            sum[i] = sum[i-1] + sum[i-2];
        }
        System.out.println(sum[N]);
    }
}
