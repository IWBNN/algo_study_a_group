class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        for (int i = 1; i <= Math.sqrt(yellow); i++) {
            if (yellow % i == 0) {
                int yellowWidth = yellow / i;
                int yellowHeight = i;
                
                if (((yellowWidth + 2) * (yellowHeight + 2) - yellow) == brown) {
                    answer[0] = yellowWidth + 2;
                    answer[1] = yellowHeight + 2;
                    break;
                }
            }
        }
        
        return answer;
    }
}