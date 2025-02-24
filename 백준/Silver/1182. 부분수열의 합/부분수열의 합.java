import java.io.*;
import java.util.*;

public class Main {
    static int N, S;
    static int[] nums;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        backtrack(0, 0);

        // S가 0인 경우, 공집합도 합이 0이 되므로 1을 빼줌
        if(S == 0) count--;

        System.out.println(count);
    }

    // index: 현재 검사할 숫자의 인덱스
    // sum: 현재까지 선택한 숫자들의 합
    static void backtrack(int index, int sum) {
        if(index == N) {
            if(sum == S) count++;
            return;
        }

        // 현재 숫자를 선택하는 경우
        backtrack(index + 1, sum + nums[index]);

        // 현재 숫자를 선택하지 않는 경우
        backtrack(index + 1, sum);
    }
}