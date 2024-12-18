import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int a, b, c, answer;
    static int[] dice;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        dice = new int[3];

        dice[0] = a;
        dice[1] = b;
        dice[2] = c;

        Arrays.sort(dice);

        if (dice[2] == dice[1] && dice[2] == dice[0]) {
            answer = 10000 + dice[2] * 1000;
        } else if (dice[2] != dice[0] && (dice[2] == dice[1] || dice[1] == dice[0]))
        {
            answer = 1000 + dice[1] * 100;
        } else {
            answer = dice[2] * 100;
        }

        System.out.println(answer);
    }
}
