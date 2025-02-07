import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        long[] buildings = new long[n];
        for(int i = 0; i < n; i++) {
            buildings[i] = Long.parseLong(br.readLine());
        }
        
        long total = 0;
        
        // 각 위치에서 오른쪽 빌딩들을 확인
        for(int i = 0; i < n - 1; i++) {  // 마지막 빌딩은 볼 수 있는 빌딩이 없음
            for(int j = i + 1; j < n; j++) {
                if(buildings[i] <= buildings[j]) {  // 자신보다 크거나 같은 빌딩을 만나면 break
                    break;
                }
                total++;  // 볼 수 있는 빌딩 카운트
            }
        }
        
        System.out.println(total);
    }
}