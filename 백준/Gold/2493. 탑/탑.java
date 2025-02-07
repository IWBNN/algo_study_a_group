import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] towers = new int[n];

        // 탑 높이 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            towers[i] = Integer.parseInt(st.nextToken());
        }

        Stack<int[]> stack = new Stack<>();  // [인덱스, 높이]를 저장
        // stack 을 배열로 받아 위치와 높이 모두 제어하는 것이 포인트
        int[] answer = new int[n];

        for(int i = 0; i < n; i++) {
            // 현재 탑보다 낮은 탑은 제거
            while(!stack.isEmpty() && stack.peek()[1] < towers[i]) {
                stack.pop();
            }

            // 수신 탑 찾기
            if(!stack.isEmpty()) {
                answer[i] = stack.peek()[0] + 1;  // 1-based index로 변환
            }

            // 현재 탑 정보 스택에 추가
            stack.push(new int[]{i, towers[i]});
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for(int num : answer) {
            sb.append(num).append(" ");
        }
        System.out.println(sb);
    }
}