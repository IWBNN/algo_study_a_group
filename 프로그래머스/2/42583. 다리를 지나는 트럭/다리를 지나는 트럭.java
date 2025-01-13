import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new LinkedList<>();
        int time = 0;
        int currentWeight = 0;
        int truckIndex = 0;
        
        // 다리의 길이만큼 0으로 채우기 (빈 공간 표시)
        for (int i = 0; i < bridge_length; i++) {
            bridge.offer(0);
        }
        
        // 모든 트럭이 다리를 건널 때까지
        while (truckIndex < truck_weights.length) {
            // 시간 증가
            time++;
            
            // 다리에서 나가는 트럭의 무게를 전체 무게에서 빼기
            currentWeight -= bridge.poll();
            
            // 새 트럭이 다리에 올라갈 수 있는지 확인
            if (currentWeight + truck_weights[truckIndex] <= weight) {
                bridge.offer(truck_weights[truckIndex]);
                currentWeight += truck_weights[truckIndex];
                truckIndex++;
            } else {
                bridge.offer(0);  // 트럭이 올라갈 수 없으면 빈 공간 추가
            }
        }
        
        // 마지막 트럭이 다리를 건너는 시간 추가
        time += bridge_length;
        
        return time;
    }
}