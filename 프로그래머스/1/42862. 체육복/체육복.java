class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        // -1: 도난, 0: 정상, 1: 여벌
        int[] students = new int[n + 2];
        
        for(int r : reserve) {
            students[r]++;
        }
        
        for(int l : lost) {
            students[l]--;
        }
        
        for(int i = 1; i <= n; i++) {
            if(students[i] == -1) {
                if(students[i-1] == 1) {
                    students[i]++;
                    students[i-1]--;
                } else if(students[i+1] == 1) {
                    students[i]++;
                    students[i+1]--;
                }
            }
        }
        
        int answer = 0;
        for(int i = 1; i <= n; i++) {
            if(students[i] >= 0) answer++;
        }
        
        return answer;
    }
}