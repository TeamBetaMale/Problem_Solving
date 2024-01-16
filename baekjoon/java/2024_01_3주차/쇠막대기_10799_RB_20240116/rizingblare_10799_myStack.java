import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        String S = br.readLine();
        MyStack stack = new MyStack(S.length());

        int result = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                if (S.charAt(i+1) == ')') {
                    stack.up();
                    i++;
                }
                else stack.push(1);
            }

            else if (S.charAt(i) == ')') {
                //sb.append(stack.peek()).append("\n");
                result += stack.peek();
                stack.pop();
            }

        }
        sb.append(result).append("\n");

        System.out.println(sb);
    }

    private static class MyStack {
        private int[] data;
        private int pos;

        public MyStack(int N) {
            this.data = new int[N];
            this.pos = 0;
        }

        public void push(int newItem) {
            data[pos++] = newItem;
        }

        public void pop() {
            pos--;
        }

        public int peek() {
            return data[pos-1];
        }

        public void up() {
            for (int i = 0; i < pos; i++) {
                data[i]++;
            }
        }
    }
}