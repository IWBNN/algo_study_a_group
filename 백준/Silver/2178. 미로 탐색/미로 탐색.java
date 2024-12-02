import java.io.*;
import java.util.*;

public class Main {
    // 상하좌우 이동을 위한 배열
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N, M;
    static int[][] maze;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 미로의 크기 입력
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 미로 배열 초기화
        maze = new int[N][M];

        // 미로 정보 입력
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                maze[i][j] = line.charAt(j) - '0';
            }
        }

        // BFS 실행 및 결과 출력
        System.out.println(bfs(0, 0));
    }

    public static int bfs(int startX, int startY) {
        // 방문 여부와 거리를 저장할 배열
        int[][] visited = new int[N][M];
        Queue<Point> queue = new LinkedList<>();

        // 시작점 설정
        queue.offer(new Point(startX, startY));
        visited[startX][startY] = 1; // 시작 위치도 카운트

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            // 4방향 탐색
            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                // 미로 범위 내에 있는지 확인
                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    // 이동 가능하고 아직 방문하지 않은 곳인 경우
                    if (maze[nx][ny] == 1 && visited[nx][ny] == 0) {
                        visited[nx][ny] = visited[current.x][current.y] + 1;
                        queue.offer(new Point(nx, ny));
                    }
                }
            }
        }

        // 도착점까지의 최단 거리 반환
        return visited[N-1][M-1];
    }

    // 좌표를 저장하기 위한 클래스
    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}