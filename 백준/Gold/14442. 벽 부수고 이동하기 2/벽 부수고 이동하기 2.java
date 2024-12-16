import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static int[][] map;
    static int[][][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new int[N][M][K + 1];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }
        System.out.println(bfs());
    }

    public static int bfs() {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0, 0, 1, 0));
        visited[0][0][0] = 1;

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            if (current.y == N-1 && current.x == M-1) {
                return current.distance;
            }

            for (int i = 0; i < 4; i++) {
                int ny = current.y + dy[i];
                int nx = current.x + dx[i];

                if (ny >= 0 && ny < N && nx >= 0 && nx < M) {
                    if (map[ny][nx] == 1 && current.brokenWall < K) {
                        if (visited[ny][nx][current.brokenWall] == 0) {
                            visited[ny][nx][current.brokenWall] = 1;
                            queue.offer(new Point(ny, nx, current.distance + 1, current.brokenWall + 1));
                        }
                    } else if (map[ny][nx] == 0) {
                        if (visited[ny][nx][current.brokenWall] == 0) {
                            visited[ny][nx][current.brokenWall] = 1;
                            queue.offer(new Point(ny, nx, current.distance + 1, current.brokenWall));
                        }
                    }
                }
            }
        }
        return -1;
    }

    static class Point {
        int x, y, distance, brokenWall;

        Point(int y, int x, int distance, int brokenWall) {
            this.x = x;
            this.y = y;
            this.distance = distance;
            this.brokenWall = brokenWall;
        }
    }
}
