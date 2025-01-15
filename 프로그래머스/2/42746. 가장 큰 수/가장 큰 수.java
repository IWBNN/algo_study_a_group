import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] num = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            num[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(num, (a, b) -> (b + a).compareTo(a + b));
        
        if (num[0].equals("0")) {
            return "0";
        }
        
        StringBuilder answer = new StringBuilder();
        for (String str : num) {
            answer.append(str);
        }
        
        return answer.toString();
    }
}