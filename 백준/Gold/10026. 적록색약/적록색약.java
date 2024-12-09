import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static char[][] grid;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0}; // 상하좌우 x좌표
    static int[] dy = {0, 0, -1, 1}; // 상하좌우 y좌표

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        grid = new char[N][N];

        for(int i = 0; i < N; i++) {
            String line = br.readLine();
            for(int j = 0; j < N; j++) {
                grid[i][j] = line.charAt(j);
            }
        }

        int normal = 0;
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    dfs(i, j, grid[i][j], false);
                    normal++;
                }
            }
        }

        int colorBlind = 0;
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    dfs(i, j, grid[i][j], true);
                    colorBlind++;
                }
            }
        }

        System.out.println(normal + " " + colorBlind);
    }

    static void dfs(int x, int y, char color, boolean isColorBlind) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
                if (!isColorBlind && grid[nx][ny] == color) {
                    dfs(nx, ny, color, false);
                }
                else if (isColorBlind) {
                    if ((color == 'B' && grid[nx][ny] == 'B') ||
                            (color != 'B' && grid[nx][ny] != 'B')) {
                        dfs(nx, ny, color, true);
                    }
                }
            }
        }
    }
}
