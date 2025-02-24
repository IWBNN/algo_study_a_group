import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        combination(0, 1);
        System.out.print(sb);
    }

    static void combination(int depth, int start) {
        // M개를 모두 선택했으면 출력
        if (depth == M) {
            for (int val : arr) {
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
        }

        // start부터 N까지의 수 중에서 선택
        for (int i = 1; i <= N; i++) {
            arr[depth] = i;
            combination(depth + 1, i + 1);  // 다음 수는 현재 선택한 수보다 커야 함
        }
    }
}