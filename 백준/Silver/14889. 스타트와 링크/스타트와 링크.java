import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, minDiff = Integer.MAX_VALUE;
    static int[][] arr;
    static boolean[] selected; // 스타트 팀으로 선택된 사람

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        selected = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backTracking(0, 0);
        System.out.println(minDiff);
    }

    // idx: 현재 검사할 사람 인덱스, count: 스타트 팀으로 선택된 사람 수
    static void backTracking(int idx, int count) {
        // N/2명이 스타트 팀으로 모두 선택되었을 때
        if(count == N/2) {
            // 팀 능력치 계산
            calculateDifference();
            return;
        }

        // 더 이상 선택할 사람이 없는 경우
        if(idx == N) return;

        // 현재 사람을 스타트 팀에 선택
        selected[idx] = true;
        backTracking(idx + 1, count + 1);

        // 현재 사람을 스타트 팀에 선택하지 않음 (링크 팀이 됨)
        selected[idx] = false;
        backTracking(idx + 1, count);
    }

    // 두 팀의 능력치 차이 계산
    static void calculateDifference() {
        int startTeamSum = 0;
        int linkTeamSum = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 둘 다 스타트 팀에 속한 경우
                if (selected[i] && selected[j]) {
                    startTeamSum += arr[i][j];
                }
                // 둘 다 링크 팀에 속한 경우
                else if (!selected[i] && !selected[j]) {
                    linkTeamSum += arr[i][j];
                }
            }
        }

        int diff = Math.abs(startTeamSum - linkTeamSum);
        minDiff = Math.min(minDiff, diff);
    }
}