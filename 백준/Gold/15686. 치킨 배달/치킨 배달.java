import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M, minTotalDistance = Integer.MAX_VALUE;
    static int[][] city;
    static List<Point> homes = new ArrayList<>();
    static List<Point> chickens = new ArrayList<>();
    static boolean[] selected;

    static class Point {
        int r, c;

        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        city = new int[N][N];

        // 도시 정보 입력 및 집, 치킨집 위치 저장
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());

                if (city[i][j] == 1) {
                    homes.add(new Point(i, j)); // 집 위치 저장
                } else if (city[i][j] == 2) {
                    chickens.add(new Point(i, j)); // 치킨집 위치 저장
                }
            }
        }

        selected = new boolean[chickens.size()];

        // 치킨집 중 M개 선택하는 조합 찾기
        selectChicken(0, 0);

        System.out.println(minTotalDistance);
    }

    // 치킨집 중 M개를 선택하는 모든 조합 시도 (백트래킹)
    static void selectChicken(int start, int count) {
        if (count == M) {
            // M개의 치킨집이 선택되었으면 치킨 거리 계산
            calculateChickenDistance();
            return;
        }

        for (int i = start; i < chickens.size(); i++) {
            if (!selected[i]) {
                selected[i] = true;
                selectChicken(i + 1, count + 1);
                selected[i] = false;
            }
        }
    }

    // 선택된 치킨집들로 도시의 치킨 거리 계산
    static void calculateChickenDistance() {
        int totalDistance = 0;

        // 각 집에 대해 치킨 거리 계산
        for (Point home : homes) {
            int minDistance = Integer.MAX_VALUE;

            // 선택된 치킨집들 중 가장 가까운 치킨 거리 찾기
            for (int i = 0; i < chickens.size(); i++) {
                if (selected[i]) {
                    Point chicken = chickens.get(i);
                    int distance = Math.abs(home.r - chicken.r) + Math.abs(home.c - chicken.c);
                    minDistance = Math.min(minDistance, distance);
                }
            }

            totalDistance += minDistance;
        }

        // 도시의 최소 치킨 거리 갱신
        minTotalDistance = Math.min(minTotalDistance, totalDistance);
    }
}