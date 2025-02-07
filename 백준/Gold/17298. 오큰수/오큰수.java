import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];    // 입력 배열
        int[] answer = new int[n];  // 결과 배열
        
        // 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Stack<Integer> stack = new Stack<>();  // 인덱스를 저장할 스택
        
        // 처음부터 끝까지 순회
        for(int i = 0; i < n; i++) {
            // 스택이 비어있지 않고, 현재 수가 스택 top 인덱스의 수보다 크면
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                answer[stack.pop()] = arr[i];  // 오큰수 업데이트
            }
            stack.push(i);  // 현재 인덱스를 스택에 추가
        }
        
        // 스택에 남아있는 인덱스들은 오큰수가 없는 경우
        while(!stack.isEmpty()) {
            answer[stack.pop()] = -1;
        }
        
        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for(int num : answer) {
            sb.append(num).append(" ");
        }
        System.out.println(sb);
    }
}