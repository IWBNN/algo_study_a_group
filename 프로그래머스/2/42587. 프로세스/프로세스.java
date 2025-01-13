import java.util.*;

class Solution {
    class Process {
        int priority;
        int location;
        
        Process(int priority, int location) {
            this.priority = priority;
            this.location = location;
        }
    }
    
    public int solution(int[] priorities, int location) {
        Queue<Process> queue = new LinkedList<>();
        
        // 프로세스를 큐에 넣기
        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new Process(priorities[i], i));
        }
        
        int order = 0;
        
        while (!queue.isEmpty()) {
            Process current = queue.poll();
            boolean hasHigherPriority = false;
            
            // 현재 프로세스보다 우선순위가 높은 프로세스가 있는지 확인
            for (Process p : queue) {
                if (p.priority > current.priority) {
                    hasHigherPriority = true;
                    break;
                }
            }
            
            if (hasHigherPriority) {
                queue.offer(current);  // 다시 큐에 넣기
            } else {
                order++;  // 실행 순서 증가
                if (current.location == location) {
                    return order;  // 찾는 프로세스라면 현재 순서 반환
                }
            }
        }
        
        return order;
    }
}