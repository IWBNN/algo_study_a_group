import java.util.Scanner;

public class Main { //1418
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 입력 받기
        int N = scanner.nextInt();
        int K = scanner.nextInt();

        int count = 0;

        // N보다 작거나 같은 수에 대해 반복
        for (int i = 1; i <= N; i++) {
            int maxPrimeFactor = getMaxPrimeFactor(i);

            // 최댓값이 K보다 작거나 같으면 K-세준수로 카운트
            if (maxPrimeFactor <= K) {
                count++;
            }
        }

        // 결과 출력
        System.out.println(count);

        scanner.close();
    }

    // 소인수 중 최댓값을 반환하는 함수
    private static int getMaxPrimeFactor(int num) {
        int maxFactor = 0;

        // 2부터 num까지의 수에 대해 소인수 분해
        for (int i = 2; i <= num; i++) {
            while (num % i == 0) {
                maxFactor = Math.max(maxFactor, i);
                num /= i;
            }
        }

        return maxFactor;
    }
}
