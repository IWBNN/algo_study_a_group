import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        
        // 0부터 최대 인용 횟수까지 h값 탐색
        for (int h = citations.length; h >= 0; h--) {
            int over = 0;  // h번 이상 인용된 논문 수
            int under = 0; // h번 이하 인용된 논문 수
            
            for (int j = 0; j < citations.length; j++) {
                if (citations[j] >= h) over++;
                if (citations[j] <= h) under++;
            }
            
            // h번 이상 인용된 논문이 h편 이상이고
            // 나머지 논문이 h번 이하 인용되었다면
            if (over >= h && under <= citations.length - h) {
                return h;
            }
        }
        
        return 0;
    }
}