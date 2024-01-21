import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        String command = br.readLine();

        Stack<Character> stack = new Stack<>();
        HashMap<Character, Integer> rank = new HashMap<>();
        rank.put('(', 0);
        rank.put(')', 0);
        rank.put('+', 1);
        rank.put('-', 1);
        rank.put('*', 2);
        rank.put('/', 2);

        for (int i = 0; i < command.length(); i++) {
            if ('A' <= command.charAt(i) && command.charAt(i) <= 'Z') {
                sb.append(command.charAt(i));
            }
            else {
                if (stack.empty()) {
                    stack.push(command.charAt(i));
                }

                else if ('(' == command.charAt(i)) {
                    stack.push(command.charAt(i));
                }

                else if (')' == command.charAt(i)) {
                    while (!stack.empty() && stack.peek() != '(') {
                        sb.append(stack.peek());
                        stack.pop();
                    }
                    stack.pop();
                }

                else {
                    while (!stack.empty() &&
                            rank.get(command.charAt(i))
                            <= rank.get(stack.peek())) {
                        sb.append(stack.peek());
                        stack.pop();
                    }
                    stack.push(command.charAt(i));
                }
            }
        }

        while (!stack.empty()) {
            sb.append(stack.peek());
            stack.pop();
        }

        System.out.println(sb);
    }
}