import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] board;
    static int[] dx = {-1, -1};  // 좌상, 우상 대각선 행 방향
    static int[] dy = {-1, 1};   // 좌상, 우상 대각선 열 방향

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        // 체스판 정보 입력
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 검은 칸과 흰 칸을 각각 계산하여 합산
        int blackResult = backtrack(0, true);
        int whiteResult = backtrack(0, false);

        System.out.println(blackResult + whiteResult);
    }

    // color: true면 검은칸, false면 흰칸
    static int backtrack(int start, boolean color) {
        int maxBishops = 0;
        for(int i = start; i < N * N; i++) {
            int row = i / N;
            int col = i % N;

            // 현재 칸이 처리하려는 색상의 칸이 아니거나, 비숍을 놓을 수 없는 칸이면 건너뜀
            if(((row + col) % 2 == 0) != color || board[row][col] == 0) continue;

            // 비숍을 놓을 수 있는지 확인
            if(canPlace(row, col)) {
                board[row][col] = 2;  // 비숍 놓기
                maxBishops = Math.max(maxBishops, 1 + backtrack(i + 1, color));
                board[row][col] = 1;  // 비숍 제거
            }
        }
        return maxBishops;
    }

    static boolean canPlace(int row, int col) {
        // 현재 위치에서 양쪽 대각선 방향으로 비숍이 있는지 확인
        for(int d = 0; d < 2; d++) {
            int nx = row + dx[d];
            int ny = col + dy[d];
            while(nx >= 0 && nx < N && ny >= 0 && ny < N) {
                if(board[nx][ny] == 2) return false;  // 다른 비숍이 있음
                nx += dx[d];
                ny += dy[d];
            }
        }
        return true;
    }
}