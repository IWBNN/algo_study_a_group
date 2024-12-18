import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();

        LinkedHashSet<String> set = new LinkedHashSet<String>();

        for (int i = 0; i < line.length(); i++) {
            for (int j = 1; j <= line.length() - i; j++) {
                set.add(line.substring(i, i + j));
            }
        }

        System.out.println(set.size());
    }
}
