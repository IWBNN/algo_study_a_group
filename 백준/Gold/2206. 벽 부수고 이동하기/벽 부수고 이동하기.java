import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M][2];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) -'0';
            }
        }
        System.out.println(bfs());
    }

    static class Point {
        int x, y, distance;
        boolean brokenWall;

        Point(int y, int x, int distance, boolean brokenWall) {
            this.x = x;
            this.y = y;
            this.distance = distance;
            this.brokenWall = brokenWall;
        }
    }

    public static int bfs() {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0,0,1,false));
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            if (current.y == N-1 && current.x == M-1) {
                return current.distance;
            }

            for (int i = 0; i < 4; i++) {
                int ny = current.y + dy[i];
                int nx = current.x + dx[i];

                if (ny >= 0 && ny < N && nx >= 0 && nx < M) {
                    if (map[ny][nx] == 1 && !current.brokenWall) {
                        if (!visited[ny][nx][1]) {
                            visited[ny][nx][1] = true;
                            queue.offer(new Point(ny, nx, current.distance + 1, true));
                        }
                    } else if (map[ny][nx] == 0) {
                        if (!visited[ny][nx][current.brokenWall ? 1 : 0]) {
                            visited[ny][nx][current.brokenWall ? 1 : 0] = true;
                            queue.offer(new Point(ny, nx, current.distance + 1, current.brokenWall));
                        }
                    }
                }
            }
        }
        return -1;
    }
}
