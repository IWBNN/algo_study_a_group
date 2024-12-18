import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int K, L;
    static LinkedHashSet<String> studentNum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        studentNum = new LinkedHashSet<>();

        for (int i = 0; i < L; i++) {
            String num = br.readLine();

            if (studentNum.contains(num)) {
                studentNum.remove(num);
            }
            studentNum.add(num);
        }
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = studentNum.iterator();
        for (int i = 0; i < K && it.hasNext(); i++) {
            sb.append(it.next()).append("\n");
        }
        System.out.println(sb);
    }
}