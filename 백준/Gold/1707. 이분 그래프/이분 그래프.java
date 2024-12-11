import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int K, V, E, u, v;
    static ArrayList<Integer>[] graph;
    static int[] colors;
    static boolean visited;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            graph = new ArrayList[V + 1];
            for (int j = 1; j <= V; j++) {
                graph[j] = new ArrayList<>();
            }

            for (int w = 0; w < E; w++) {
                st = new StringTokenizer(br.readLine());
                u = Integer.parseInt(st.nextToken());
                v = Integer.parseInt(st.nextToken());
                graph[u].add(v);
                graph[v].add(u);
            }

            colors = new int[V + 1];
            visited = true;

            for (int z = 1; z <= V; z++) {
                if(colors[z] == 0) {
                    dfs(z, 1);
                }
            }
            sb.append(visited ? "YES" : "NO").append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int node, int color) {
        colors[node] = color;

        for (int next : graph[node]) {
            if (colors[next] == 0) {
                dfs(next, -color);
            } else if(colors[next] == color) {
                visited =false;
                return;
            }
        }
    }

}
