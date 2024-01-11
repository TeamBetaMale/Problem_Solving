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
        MyStack stack = new MyStack(n);

        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(br.readLine());

            if (stack.top() > a) {
                System.out.println("NO");
                break;
            }

            if (stack.top() < a) {
                while (stack.top() < a) {
                    stack.push(stack.size()+1);
                }
            }

            if (stack.top() == a) {
                stack.pop();
            }

        }
    }

    private static class MyStack {

        private final int[] stack;
        private int len;

        public MyStack(int n) {
            this.stack = new int[n];
            this.len = 0;
        }

        public void push(int newItem) {
            stack[len++] = newItem;
            System.out.println("+");
        }

        public void pop() {
            if (len != 0) len--;
            System.out.println("-");
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