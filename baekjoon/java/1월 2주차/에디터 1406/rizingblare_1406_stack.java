import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        String S = br.readLine();

        int M = Integer.parseInt(br.readLine());

        MyEditor editor = new MyEditor(S);

        for (int i = 0; i < M; i++) {
            String cmd = br.readLine();

            editor.getCommand(cmd);
        }

        editor.print();
    }


    private static class MyEditor {
        private MyStack left;
        private MyStack right;

        public MyEditor(String S) {
            this.left = new MyStack(S);
            this.right = new MyStack();
        }


        public void getCommand(String cmd) {

            switch (cmd.charAt(0)) {
                case 'P':
                    left.push(cmd.charAt(2));
                    break;
                case 'L':
                    if (!left.isEmpty())
                        right.push(left.pop());
                    break;
                case 'D':
                    if (!right.isEmpty())
                        left.push(right.pop());
                    break;
                case 'B':
                    if (!left.isEmpty())
                        left.pop();
                    break;
            }
        }

        public void print() {
            while (!left.isEmpty()) {
                right.push(left.pop());
            }

            StringBuilder sb = new StringBuilder();
            while (!right.isEmpty()) {
                sb.append(right.pop());
            }

            System.out.println(sb);
        }
    }

    private static class MyStack {
        private char[] stack;
        private int len;

        public MyStack() {
            this.stack = new char[600001];
            this.len = 0;
        }

        public MyStack(String S) {
            this.stack = new char[600001];
            this.len = 0;
            fill(S);
        }

        private void fill(String S) {
            for (int i = 0; i < S.length(); i++) {
                stack[len++] = S.charAt(i);
            }
        }

        public void push(char newItem) {
            stack[len++] = newItem;
        }

        public char pop() {
            if (len == 0) return '\0';
            len--;
            return stack[len];
        }

        public int size() {
            return len;
        }

        public boolean isEmpty() {
            return len == 0;
        }
    }
}