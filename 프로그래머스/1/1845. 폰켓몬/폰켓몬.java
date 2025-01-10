import java.util.HashSet;

class Solution {
    public int solution(int[] nums) {
        // 선택할 수 있는 폰켓몬의 수
        int pickCount = nums.length / 2;
        
        // 중복을 제거한 폰켓몬 종류 수 계산
        HashSet<Integer> types = new HashSet<>();
        for(int num : nums) {
            types.add(num);
        }
        
        // 실제 폰켓몬 종류 수와 선택 가능한 폰켓몬 수 중 작은 값을 반환
        return Math.min(types.size(), pickCount);
    }
}