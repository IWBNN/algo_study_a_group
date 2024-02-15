import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0;i < T;i++){
            for(int j = 0;j < T;j++) {
                if(j < T - i - 1)bw.write(" ");
                else bw.write("*");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
}
}
