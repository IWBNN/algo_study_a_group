class Solution {
    public int solution(String name) {
        int count = 0;
        int move = name.length() - 1;
        
        for (int i = 0; i < name.length(); i++) {
            int c = (int) name.charAt(i) - 65;
            if (c >= 13) {
                c = 26 - c;
            }
            count += c;
            
            int nextChar = i + 1;
            while(nextChar < name.length() && name.charAt(nextChar) == 'A') {
                nextChar++;
            }
            
            // 정방향 -> 역방향
            int moveFront = i * 2 + (name.length() - nextChar);
            // 역방향
            int moveBack = (name.length() - nextChar) * 2 + i;
            
            move = Math.min(move, Math.min(moveFront, moveBack));
        }
        
        return count + move;
    }
}