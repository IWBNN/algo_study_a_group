import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, M, a, b;
    static ArrayList<Integer>[] smaller;
    static ArrayList<Integer>[] bigger;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        smaller = new ArrayList[N + 1];
        bigger = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            smaller[i] = new ArrayList<>();
            bigger[i] = new ArrayList<>();
        }

        for (int j = 0; j < M; j++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            smaller[b].add(a);
            bigger[a].add(b);
        }

        int answer = 0;

        for (int w = 1; w <= N; w++) {
            visited = new boolean[N + 1];
            int smallCount = dfs(w, smaller) - 1;

            visited = new boolean[N + 1];
            int bigCount = dfs(w, bigger) - 1;

            if (smallCount + bigCount == N - 1) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    static int dfs(int node, ArrayList<Integer>[] graph) {
        visited[node] = true;
        int count = 1;

        for (int next : graph[node]) {
            if (!visited[next]) {
                count += dfs(next, graph);
            }
        }
        return count;
    }
}
