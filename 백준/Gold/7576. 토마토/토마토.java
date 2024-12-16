import java.io.*;
import java.util.*;

public class Main {
    static int M, N;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<Point> queue = new LinkedList<>();
        int maxDay = 0;

        // 초기 익은 토마토들을 큐에 담기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    queue.offer(new Point(i, j, 0));
                }
            }
        }

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int ny = current.y + dy[i];
                int nx = current.x + dx[i];

                if (ny >= 0 && ny < N && nx >= 0 && nx < M && map[ny][nx] == 0) {
                    map[ny][nx] = 1;
                    queue.offer(new Point(ny, nx, current.day + 1));
                    maxDay = Math.max(maxDay, current.day + 1);
                }
            }
        }

        return checkAllRipe() ? maxDay : -1;
    }

    static boolean checkAllRipe() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    static class Point {
        int y, x, day;

        Point(int y, int x, int day) {
            this.y = y;
            this.x = x;
            this.day = day;
        }
    }
}