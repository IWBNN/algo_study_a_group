import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for(int t = 0; t < T; t++) {
            HashMap<String, Integer> clothesMap = new HashMap<>();
            int n = Integer.parseInt(br.readLine());
            
            // 의상 종류별로 개수 카운트
            for(int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String type = st.nextToken();
                
                clothesMap.put(type, clothesMap.getOrDefault(type, 0) + 1);
            }
            
            // 결과 계산
            int result = 1;
            for(int count : clothesMap.values()) {
                result *= (count + 1);  // 각 종류별로 안 입는 경우를 포함
            }
            
            System.out.println(result - 1);  // 모두 안 입는 경우 제외
        }
    }
}