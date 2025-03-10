import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int L, C, consonant, vowel; // consonant = 자음 vowel = 모음
    static String[] arr, selected;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new String[C];
        selected = new String[L];
        visited = new boolean[C];
        consonant = 0;
        vowel = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            arr[i] = st.nextToken();
        }

        Arrays.sort(arr);

        backTracking(0, 0);
        System.out.println(sb);
    }

    static void backTracking(int depth, int start) {
        if (depth == L) {
            if (consonant >= 2 && vowel >= 1) {
                for (int i = 0; i < L; i++) {
                    sb.append(selected[i]);
                }
                sb.append('\n');
                return;
            } else {
                return;
            }
        }

        for (int j = start; j < C; j++) {
            if (!visited[j]) {
                visited[j] = true;
                selected[depth] = arr[j];
                if (arr[j].equals("a") || arr[j].equals("e") || arr[j].equals("i")
                        || arr[j].equals("o") || arr[j].equals("u")) {
                    vowel++;
                } else {
                    consonant++;
                }
                backTracking(depth + 1, j + 1);
                visited[j] = false;
                if (arr[j].equals("a") || arr[j].equals("e") || arr[j].equals("i")
                        || arr[j].equals("o") || arr[j].equals("u")) {
                    vowel--;
                } else {
                    consonant--;
                }
            }
        }
    }
}
