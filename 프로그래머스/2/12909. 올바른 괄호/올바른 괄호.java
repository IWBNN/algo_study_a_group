import java.util.*;
class Solution {
    boolean solution(String s) {
        int count = 0;
        
        // 첫 문자가 ')'이면 바로 false 반환
        if (s.charAt(0) == ')') {
            return false;
        }
        
        // 문자열의 각 문자 확인
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else {
                count--;
            }
            
            // 중간에 count가 음수가 되면 올바르지 않은 괄호
            if (count < 0) {
                return false;
            }
        }
        
        // 최종적으로 count가 0이어야 올바른 괄호
        return count == 0;
    }
}