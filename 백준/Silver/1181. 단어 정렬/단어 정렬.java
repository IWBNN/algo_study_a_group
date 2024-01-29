import java.util.*;

public class Main { //1181
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.parseInt(scanner.nextLine());
        String[] TextA = new String[T];

        for (int i = 0; i < T; i++) {
            TextA[i] = scanner.next();
        }

        // 중복 제거
        HashSet<String> hashSet = new HashSet<>(Arrays.asList(TextA));
        String[] noDupTextA = hashSet.toArray(new String[0]);

        // 정렬
        Arrays.sort(noDupTextA, Comparator.comparingInt(String::length).thenComparing(Comparator.naturalOrder()));

        // 출력
        for (String word : noDupTextA) {
            System.out.println(word);
        }
    }
}
