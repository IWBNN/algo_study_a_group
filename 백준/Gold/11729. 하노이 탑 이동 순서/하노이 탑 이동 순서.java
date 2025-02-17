import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int count = 0;
    
    // from: 출발지, to: 목적지, aux: 보조 기둥
    public static void hanoi(int n, int from, int to, int aux) {
        count++;
        
        if (n == 1) {
            sb.append(from + " " + to + "\n");
            return;
        }
        
        // n-1개를 보조 기둥으로 이동
        hanoi(n-1, from, aux, to);
        
        // 가장 큰 원판을 목적지로 이동
        sb.append(from + " " + to + "\n");
        
        // n-1개를 목적지로 이동
        hanoi(n-1, aux, to, from);
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        hanoi(N, 1, 3, 2);
        
        System.out.println((int)Math.pow(2, N) - 1);  // 이동 횟수
        System.out.print(sb);
    }
}