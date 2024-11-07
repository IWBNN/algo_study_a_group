import java.util.*;

public class Main {
    static int n, m;
    static int[][] paper;
    static boolean[][] visited;
    // 상하좌우 이동을 위한 배열
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 입력 받기
        n = sc.nextInt(); // 세로 크기
        m = sc.nextInt(); // 가로 크기
        
        paper = new int[n][m];
        visited = new boolean[n][m];
        
        // 도화지 정보 입력
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                paper[i][j] = sc.nextInt();
            }
        }
        
        int pictureCount = 0;  // 그림의 개수
        int maxArea = 0;       // 가장 큰 그림의 넓이
        
        // 도화지 전체를 탐색
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                // 아직 방문하지 않은 색칠된 부분(1)을 발견하면
                if(!visited[i][j] && paper[i][j] == 1) {
                    pictureCount++; // 그림 개수 증가
                    // 현재 그림의 넓이와 최대 넓이 비교
                    maxArea = Math.max(maxArea, bfs(i, j));
                }
            }
        }
        
        // 결과 출력
        System.out.println(pictureCount);
        System.out.println(maxArea);
    }
    
    // BFS로 한 그림의 넓이 계산
    static int bfs(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY});
        visited[startX][startY] = true;
        int area = 1; // 현재 그림의 넓이
        
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            
            // 상하좌우 네 방향 확인
            for(int i = 0; i < 4; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];
                
                // 도화지 범위 내에 있고
                if(nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    // 아직 방문하지 않았으며 색칠된 부분(1)이라면
                    if(!visited[nx][ny] && paper[nx][ny] == 1) {
                        queue.offer(new int[]{nx, ny});
                        visited[nx][ny] = true;
                        area++; // 넓이 증가
                    }
                }
            }
        }
        
        return area;
    }
}