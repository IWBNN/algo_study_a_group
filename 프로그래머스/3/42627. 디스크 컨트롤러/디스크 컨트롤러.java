import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        // 요청시간 순으로 정렬
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        
        // 처리 시간 순으로 정렬되는 우선순위 큐
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        
        int time = 0;      // 현재 시간
        int total = 0;     // 총 소요시간
        int jobIdx = 0;    // 작업 배열 인덱스
        int count = 0;     // 처리된 작업 수
        
        while(count < jobs.length) {
            // 현재 시점에서 처리할 수 있는 작업 큐에 추가
            while(jobIdx < jobs.length && jobs[jobIdx][0] <= time) {
                pq.offer(jobs[jobIdx++]);
            }
            
            if(pq.isEmpty()) {
                // 처리할 수 있는 작업이 없다면 다음 작업의 요청시점으로 이동
                time = jobs[jobIdx][0];
            } else {
                // 가장 수행시간이 짧은 작업 처리
                int[] current = pq.poll();
                total += time - current[0] + current[1];
                time += current[1];
                count++;
            }
        }
        
        return total / count;
    }
}