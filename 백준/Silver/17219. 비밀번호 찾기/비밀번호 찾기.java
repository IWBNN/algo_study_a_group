import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

            HashMap<String, String> addressMap = new HashMap<>();

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                String address = st.nextToken();
                String password = st.nextToken();

                addressMap.put(address, password);
            }

            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < M; j++) {
                String site = br.readLine();

                sb.append(addressMap.get(site)).append("\n");
            }

        System.out.print(sb);
    }
}