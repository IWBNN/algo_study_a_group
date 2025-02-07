import java.util.*;

class Solution {
    public String solution(String number, int k) {
        // stack 선언
        Stack<Character> stack = new Stack<>();
        
        // string 자리를 각각 분해해서 c에 담기
        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            
            // stack 이 비지 않고, k가 0보다 크며,
            // 스택의 최상단이 들어오려는 c보다 작으면
            // 최상단의 수를 빼고 c를 넣기
            // 그렇지 않은 경우 그냥 stack 에 push
            while (!stack.isEmpty() && k > 0 && stack.peek() < c) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        
        while (k > 0) {
            stack.pop();
            k--;
        }
        
        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }
        
        return sb.toString();
    }
}