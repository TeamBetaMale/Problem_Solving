import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String s = br.readLine();
            MyStack stack = new MyStack(50);
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '(') {
                    stack.push(s.charAt(j));
                }
                if (s.charAt(j) == ')') {
                    if (stack.empty()) {
                        stack.push(s.charAt(j));
                        break;
                    }
                    else stack.pop();
                }
            }

            if (stack.empty()) {
                sb.append("YES");
            }

            else {
                sb.append("NO");
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static class MyStack {

        private final char[] stack;
        private int len;

        public MyStack(int n) {
            this.stack = new char[n];
            this.len = 0;
        }

        public void push(char newItem) {
            stack[len++] = newItem;
        }

        public void pop() {
            if (len != 0) len--;
        }

        public int size() {
            return len;
        }

        public boolean empty() {
            return len == 0;
        }

        public int top() {
            if (len == 0) return -1;
            return stack[len - 1];
        }
    }
}