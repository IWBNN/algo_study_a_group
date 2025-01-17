import java.util.*;

class Solution {
    HashSet<Integer> numberSet = new HashSet<>();
    
    public int solution(String numbers) {
        boolean[] used = new boolean[numbers.length()];
        String[] nums = numbers.split("");
        
        for (int i = 1; i <= numbers.length(); i++) {
            permutation(nums, used, "", i);
        }
        
        int answer = 0;
        for (int num : numberSet) {
            if (isPrime(num)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    private void permutation(String[] nums, boolean[] used, String current, int length) {
        if (current.length() == length) {
            int num = Integer.parseInt(current);
            numberSet.add(num);
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                permutation(nums, used, current + nums[i], length);
                used[i] = false;
            }
        }
    }
    
    private boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}