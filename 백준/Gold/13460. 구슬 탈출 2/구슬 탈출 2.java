import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;
    static char[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int rx = 0, ry = 0, bx = 0, by = 0;

        map = new char[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'R') {
                    rx = i;
                    ry = j;
                } else if (map[i][j] == 'B') {
                    bx = i;
                    by = j;
                }
            }
        }

        System.out.println(bfs(rx, ry, bx, by));
    }

    static class Marble {
        int rx, ry, bx, by, count;

        Marble(int rx, int ry, int bx, int by, int count) {
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
            this.count = count;
        }
    }

    static class Result {
        int x, y, count;

        Result(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    public static int bfs(int rx, int ry, int bx, int by) {
        Queue<Marble> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(new Marble(rx, ry, bx, by, 0));
        visited.add(rx + "," + ry + "," + bx + "," + by);

        while(!queue.isEmpty()) {
            Marble marble = queue.poll();

            if (marble.count >= 10) return -1;

            for (int i = 0; i < 4; i++) {
                Result blue = move(marble.bx, marble.by, dx[i], dy[i]);
                Result red = move(marble.rx, marble.ry, dx[i], dy[i]);

                if (map[blue.x][blue.y] == 'O') continue;

                if (map[red.x][red.y] == 'O') {
                    return marble.count + 1;
                }

                if (red.x == blue.x && red.y == blue.y) {
                    if (red.count > blue.count) {
                        red.x -= dx[i];
                        red.y -= dy[i];
                    } else {
                        blue.x -= dx[i];
                        blue.y -= dy[i];
                    }
                }

                String key = red.x + "," + red.y + "," + blue.x + "," + blue.y;
                if (!visited.contains(key)) {
                    visited.add(key);
                    queue.add(new Marble(red.x, red.y, blue.x, blue.y, marble.count + 1));
                }
            }
        }
        return -1;
    }

    static Result move (int x, int y, int dx, int dy) {
        int count = 0;

        while(map[x+dx][y+dy] != '#' && map[x][y] != 'O') {
            x += dx;
            y += dy;
            count++;
        }
        return new Result(x, y, count);
    }
}
