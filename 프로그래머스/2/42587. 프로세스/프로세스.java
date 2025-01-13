import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        // 프로세스 위치와 우선순위 저장하는 큐
        Queue<Integer> queue = new LinkedList<>();
        // 우선순위 내림차순 정렬을 위한 우선순위 큐
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        
        // 큐에 위치 저장, 우선순위 큐에 우선순위 저장
        for (int i = 0; i < priorities.length; i++) {
            queue.offer(i);
            priorityQueue.offer(priorities[i]);
        }
        
        int answer = 1;  // 실행 순서
        
        while (!queue.isEmpty()) {
            int currentLocation = queue.poll();
            
            // 현재 프로세스의 우선순위가 최대 우선순위와 같으면 실행
            if (priorities[currentLocation] == priorityQueue.peek()) {
                if (currentLocation == location) {
                    return answer;
                }
                priorityQueue.poll();
                answer++;
            } else {
                // 아니면 큐의 맨 뒤로
                queue.offer(currentLocation);
            }
        }
        
        return answer;
    }
}