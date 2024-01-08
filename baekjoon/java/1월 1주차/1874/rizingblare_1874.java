import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());
        MyStack numbers = new MyStack(n);
        numbers.fill(n);

        MyStack stack = new MyStack(n);

        boolean isStack = true;

        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(br.readLine());

            if (stack.top() > a) {
                isStack = false;
            }

            if (stack.top() < a) {
                while (stack.top() < a) {
                    sb.append("+").append("\n");
                    stack.push(numbers.pop());
                }
            }

            if (stack.top() == a) {
                sb.append("-").append("\n");
                stack.pop();
            }
        }

        if (isStack) {
            System.out.println(sb);
        }

        else {
            System.out.println("NO");
        }
    }

    private static class MyStack {

        private final int[] stack;
        private int len;


        public MyStack(int n) {
            this.stack = new int[n];
            this.len = 0;
        }


        public void fill(int n) {
            if (len == 0) {
                for (int i = n; i > 0; i--) {
                    stack[len++] = i;
                }
            }
        }

        public void push(int newItem) {
            stack[len++] = newItem;
        }

        public int pop() {
            if (len != 0) len--;
            return stack[len];
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