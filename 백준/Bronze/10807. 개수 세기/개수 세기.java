import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((System.out)));

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[] ArrayA = new int[T];
        int count = 0;
        st = new StringTokenizer(br.readLine());

        for(int i = 0;i < T;i++){
            ArrayA[i] = Integer.parseInt(st.nextToken());
        }
        int C = Integer.parseInt(br.readLine());
        for(int j = 0;j < T;j++){
            if(ArrayA[j] == C)
                count++;
        }
        bw.write(count + " ");
        bw.flush();
        bw.close();

    }
}
