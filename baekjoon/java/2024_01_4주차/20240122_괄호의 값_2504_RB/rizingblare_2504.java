import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        String input = br.readLine();

        System.out.println(solve(input));
    }

    private static int solve(String s) {
        List<Character> openBracket = List.of('(','[');
        List<Character> closeBracket = List.of(')',']');

        Stack<Character> stack = new Stack<>();

        int result = 0;
        int point = 1;
        for (int i = 0; i < s.length(); i++) {
            if (openBracket.contains(s.charAt(i))) {
                if (s.charAt(i) == '(') {
                        point *= 2;
                        stack.push(s.charAt(i));
                }

                if (s.charAt(i) == '[') {
                    point *= 3;
                    stack.push(s.charAt(i));
                }
            }

            else if (closeBracket.contains(s.charAt(i))) {
                if (stack.empty()) {
                    return 0;
                }

                else {
                    if (closeBracket.indexOf(s.charAt(i)) != openBracket.indexOf(stack.peek())) {
                        return 0;
                    }

                    else {
                        if (s.charAt(i) == ')') {
                            if (s.charAt(i-1) == '(') {
                                result += point;
                            }
                            point /= 2;
                            stack.pop();
                        }

                        if (s.charAt(i) == ']') {
                            if (s.charAt(i-1) == '[') {
                                result += point;
                            }
                            point /= 3;
                            stack.pop();
                        }
                    }
                }
            }
        }

        if (stack.empty()) {
            return result;
        }
        else {
            return 0;
        }
    }
}