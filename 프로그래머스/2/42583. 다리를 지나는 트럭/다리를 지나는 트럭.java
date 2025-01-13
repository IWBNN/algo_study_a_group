import java.util.*;

class Solution {
    class Truck {
        int weight;
        int exitTime;    // 다리를 빠져나가는 시간
        
        Truck(int weight, int exitTime) {
            this.weight = weight;
            this.exitTime = exitTime;
        }
    }
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Truck> bridge = new LinkedList<>();
        int currentWeight = 0;
        int time = 0;
        int truckIndex = 0;
        
        while(truckIndex < truck_weights.length || !bridge.isEmpty()) {
            // 현재 시간에 다리를 빠져나가는 트럭 처리
            if(!bridge.isEmpty() && bridge.peek().exitTime == time) {
                currentWeight -= bridge.poll().weight;
            }
            
            // 새 트럭이 다리에 올라갈 수 있는지 확인
            if(truckIndex < truck_weights.length && 
               currentWeight + truck_weights[truckIndex] <= weight) {
                currentWeight += truck_weights[truckIndex];
                bridge.offer(new Truck(truck_weights[truckIndex], 
                                     time + bridge_length));
                truckIndex++;
            }
            
            time++;
        }
        
        return time;
    }
}