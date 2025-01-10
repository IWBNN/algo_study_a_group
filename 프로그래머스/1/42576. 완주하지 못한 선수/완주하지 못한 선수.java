import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        
        // 참가자의 이름과 인원 수를 저장
        for (String name : participant) {
            map.put(name, map.getOrDefault(name, 0) + 1);
        }
        
        // 완주자를 제거
        for (String name : completion) {
            map.put(name, map.get(name) - 1);
            if (map.get(name) == 0) {
                map.remove(name);
            }
        }
        
        // 남은 한 명이 완주하지 못한 선수
        return map.keySet().iterator().next();
    }
}