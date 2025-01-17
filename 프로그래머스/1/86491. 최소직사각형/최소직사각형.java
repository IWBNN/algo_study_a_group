class Solution {
    public int solution(int[][] sizes) {
        int[] x = new int[sizes.length];
        int[] y = new int[sizes.length];
        // [[0][1], [0][5]]
        for(int i = 0; i < sizes.length; i++) {
            if (sizes[i][0] >= sizes[i][1]) {
                x[i] = sizes[i][0];
                y[i] = sizes[i][1];
            } else {
                x[i] = sizes[i][1];
                y[i] = sizes[i][0];
            }
        }
        
        int maxX = 0;
        int maxY = 0;
        
        for (int j = 0; j < sizes.length; j++) {
            if(maxX < x[j]) {
                maxX = x[j];
            }
            
            if(maxY < y[j]) {
                maxY = y[j];
            }
        }
        
        int answer = maxX * maxY;
        return answer;
    }
}