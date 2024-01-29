import java.util.Scanner;

public class Main { // 1193
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int X = scanner.nextInt();

        int a = 1;
        int b = 1;
       
        boolean up = true;  // 방향을 나타내는 플래그

        for (int i = 1; i < X; i++) {
            if (up) {
                a--;
                b++;
            } else {
                a++;
                b--;
            }

            if (a == 0) {
                up = !up;
                a++;
            } else if (b == 0){
                up = !up;
                b++;
            }
        }

        System.out.println(a + "/" + b);
    }
}
