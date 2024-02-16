import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        boolean lazer = false;
        int pipeCount = 0;
        int sum = 0;
        Stack<Character> stack = new Stack<>();

        for(int i = 0;i < str.length();i++){
            if (str.charAt(i) == '('){
                stack.push(str.charAt(i));
                lazer = true;
                pipeCount++;
            }
            if (str.charAt(i)==')'){
                if (str.charAt(i-1)== '(') {
                    stack.pop();
                    pipeCount--;
                    sum += pipeCount;
                } else {
                    pipeCount--;
                }
            }
        }
        sum += stack.size();
        System.out.println(sum);
    }
}
