import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        
        // 첫 번째 원소 먼저 스택에 넣기
        stack.push(arr[0]);
        
        // 나머지 원소들 비교하면서 스택에 넣기
        for (int i = 1; i < arr.length; i++) {
            // 스택의 top과 현재 원소가 다르면 스택에 추가
            if (stack.peek() != arr[i]) {
                stack.push(arr[i]);
            }
        }
        
        // 스택을 배열로 변환
        int[] answer = new int[stack.size()];
        for (int i = answer.length - 1; i >= 0; i--) {
            answer[i] = stack.pop();
        }
        
        return answer;
    }
}