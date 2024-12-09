import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String calculation = br.readLine();

        int answer = 0;

        String[] separation = calculation.split("-");
        // 55-50+40 의 경우 55 / 50+40 으로 나뉠 것

        String[] firstGroup = separation[0].split("\\+");
        for (String num : firstGroup) {
            answer += Integer.parseInt(num);
        }

        for (int i = 1; i < separation.length; i++) {
            int temp = 0;
            String[] nums = separation[i].split("\\+");
            for (String num : nums) {
                temp += Integer.parseInt(num);
            }
            answer -= temp;
        }

        System.out.println(answer);
    }
}
