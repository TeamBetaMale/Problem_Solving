import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        List<String> array = new ArrayList<>();

        String input;
        while (!".".equals(input= br.readLine())) {
            array.addAll(Arrays.asList(input.split("\\.")));
        }

        for (String s : array) {
            sb.append(solve(s)).append("\n");
        }

        System.out.println(sb);
    }

    private static String solve(String s) {
        List<Character> openBracket = List.of('(','[');
        List<Character> closeBracket = List.of(')',']');

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (openBracket.contains(c)) {
                stack.push(c);
            }
            else if (closeBracket.contains(c)) {

                if (stack.empty()) {
                    return "no";
                }

                else {
                    if (closeBracket.indexOf(c) == openBracket.indexOf(stack.peek())) {
                        stack.pop();
                    }
                    else {
                        return "no";
                    }
                }
            }
        }

        if (stack.empty()) {
            return "yes";
        }
        else {
            return "no";
        }
    }
}