import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        // 한번에 최대 2명이므로 가장 가벼운 사람과 무거운 사람을 매칭하여 계산
        Arrays.sort(people);
        
        int answer = 0;
        
        // 좌 : 가벼움
        int left = 0;           
        int right = people.length - 1;
        
        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;
                right--;
            }
            else {
                right--;
            }
            answer++;
        }
        
        return answer;
    }
}