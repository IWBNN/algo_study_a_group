class Solution {
    private boolean[] visited;
    private int maxCount = 0;
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        explore(k, dungeons, 0);
        return maxCount;
    }
    
    private void explore(int fatigue, int[][] dungeons, int count) {
        maxCount = Math.max(maxCount, count);
        
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && fatigue >= dungeons[i][0]) {
                visited[i] = true;
                explore(fatigue - dungeons[i][1], dungeons, count + 1);
                visited[i] = false;
            }
        }
    }
}