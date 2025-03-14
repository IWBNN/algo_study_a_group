import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < N; i++) {
            String[] command = br.readLine().split(" ");

            switch(command[0]) {
                case "push":
                    stack.push(Integer.parseInt(command[1]));
                    break;

                case "pop":
                    sb.append(stack.empty() ? -1 : stack.pop()).append('\n');
                    break;

                case "size":
                    sb.append(stack.size()).append('\n');
                    break;

                case "empty":
                    sb.append(stack.empty() ? 1 : 0).append('\n');
                    break;

                case "top":
                    sb.append(stack.empty() ? -1 : stack.peek()).append('\n');
                    break;
            }
        }

        System.out.println(sb);
    }
}