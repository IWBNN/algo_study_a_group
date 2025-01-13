import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        
        int count = 0;
        int prevTime = 0;
        
        for (int i = 0; i < progresses.length; i++) {
            // 현재 작업이 완료되는데 필요한 시간 계산
            int time = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
            
            if (i == 0) {  // 첫 번째 작업
                prevTime = time;
                count = 1;
            } else if (prevTime >= time) {  // 이전 작업보다 일찍 끝나는 경우
                count++;
            } else {  // 이전 작업보다 늦게 끝나는 경우
                queue.offer(count);  // 이전까지의 카운트를 큐에 저장
                prevTime = time;     // 새로운 기준 시간 설정
                count = 1;           // 카운트 초기화
            }
        }
        queue.offer(count);  // 마지막 카운트 저장
        
        // 큐를 배열로 변환
        int[] answer = new int[queue.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = queue.poll();
        }
        
        return answer;
    }
}