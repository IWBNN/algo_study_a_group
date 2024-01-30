import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException { // 1312
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//        double T = (21.0 / 5.0);
//        System.out.println(T);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int sum = 0;

        for(int i =0;i<c;i++){
            a = (a%b) * 10;
            sum = a/b;
        }
        System.out.println(sum);
    }
}
