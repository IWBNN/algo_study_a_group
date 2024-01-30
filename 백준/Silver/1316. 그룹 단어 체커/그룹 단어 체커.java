import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine(); // 개행 문자 처리

        int count = 0;
        for (int i = 0; i < N; i++) {
            String word = scanner.nextLine();

            // 각 알파벳의 마지막 등장 인덱스를 저장하는 배열
            int[] lastAppearance = new int[26];

            boolean isGroupWord = true;
            for (int j = 0; j < word.length(); j++) {
                char currentChar = word.charAt(j);
                int currentCharIndex = currentChar - 'a';

                // 이미 나온 알파벳이면서 연속되지 않은 경우
                if (lastAppearance[currentCharIndex] != 0 && lastAppearance[currentCharIndex] != j) {
                    isGroupWord = false;
                    break;
                }

                // 현재 알파벳의 마지막 등장 인덱스 갱신
                lastAppearance[currentCharIndex] = j + 1;
            }

            // 그룹 단어인 경우 count 증가
            if (isGroupWord) {
                count++;
            }
        }

        System.out.println(count);
    }
}
