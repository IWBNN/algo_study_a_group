import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] ArrayA = new int[N];
        int[] ArrayB = new int[N];
        int i = 0;
        int j = 0;
        for(i = 0;i < N;i++){
            ArrayA[i] = i + 1;
        }
        int count = 1;
        i = 0;
        while(j < N){
                if(ArrayA[i] != 0) {
                    if (count == K) {
                        ArrayB[j] = ArrayA[i];
                        ArrayA[i] = 0;
                        j++;
                        count = 1;
                    } else {
                        count++;
                    }
                }
            i++;
                if(i == N){
                    i = 0;
                }
        }
        bw.write("<");
        for(j = 0;j < N-1;j++){
            bw.write(ArrayB[j] + ", ");
        }
        bw.write(ArrayB[N - 1] + ">");
        bw.flush();
        bw.close();
    }
}
