import java.io.*;
import java.util.*;

public class Main {
    static int N, M, maxSafeArea = 0;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        // 연구소 지도 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 벽 3개 세우기
        buildWall(0);

        System.out.println(maxSafeArea);
    }

    // 벽을 3개 세우는 모든 경우의 수 시도 (백트래킹)
    static void buildWall(int count) {
        // 벽 3개를 모두 세웠으면 바이러스 확산 시뮬레이션
        if (count == 3) {
            spreadVirus();
            return;
        }

        // 모든 빈 칸에 벽을 하나씩 세워보기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1; // 벽 세우기
                    buildWall(count + 1);
                    map[i][j] = 0; // 벽 제거 (백트래킹)
                }
            }
        }
    }

    // 바이러스 확산 시뮬레이션 (BFS)
    static void spreadVirus() {
        Queue<int[]> queue = new LinkedList<>();
        int[][] tempMap = new int[N][M];

        // 맵 복사 및 바이러스 위치 큐에 추가
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tempMap[i][j] = map[i][j];
                if (tempMap[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        // BFS로 바이러스 확산
        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];

                // 범위 내이고 빈 칸이면 바이러스 확산
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && tempMap[nx][ny] == 0) {
                    tempMap[nx][ny] = 2;
                    queue.add(new int[]{nx, ny});
                }
            }
        }

        // 안전 영역 크기 계산
        int safeArea = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tempMap[i][j] == 0) {
                    safeArea++;
                }
            }
        }

        // 최대 안전 영역 크기 갱신
        maxSafeArea = Math.max(maxSafeArea, safeArea);
    }
}