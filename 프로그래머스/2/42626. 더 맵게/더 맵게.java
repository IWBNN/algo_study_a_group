import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        // 모든 스코빌 지수를 우선순위 큐에 넣기
        for (int scov : scoville) {
            pq.offer(scov);
        }
        
        int count = 0;
        
        // 가장 작은 값이 K보다 작은 동안 반복
        while (pq.peek() < K) {
            // 음식이 1개 이하로 남았다면 K 이상으로 만들 수 없음
            if (pq.size() < 2) return -1;
            
            // 가장 작은 두 수 꺼내기
            int first = pq.poll();
            int second = pq.poll();
            
            // 새로운 스코빌 지수 계산하여 추가
            int newScoville = first + (second * 2);
            pq.offer(newScoville);
            
            count++;
        }
        
        return count;
    }
}