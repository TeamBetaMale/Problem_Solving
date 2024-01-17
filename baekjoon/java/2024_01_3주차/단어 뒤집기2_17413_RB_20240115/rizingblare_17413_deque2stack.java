import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        String S = br.readLine();
        MyDeque stack = new MyDeque(100001);

        boolean flagForward = false;

        for (char c : S.toCharArray()) {
            if (c == '<') {
                while (!stack.empty()) {
                    sb.append(stack.back());
                    stack.pop_back();
                }
                flagForward = true;
                sb.append(c);
            }

            else if (c == '>') {
                flagForward = false;
                sb.append(c);
            }

            else if (flagForward) {
                sb.append(c);
            }

            else {
                if (c == ' ') {
                    while (!stack.empty()) {
                        sb.append(stack.back());
                        stack.pop_back();
                    }
                    sb.append(c);
                }

                else {
                    stack.push_back(c);
                }
            }
        }
        while (!stack.empty()) {
            sb.append(stack.back());
            stack.pop_back();
        }
        System.out.println(sb);
    }

    private static class MyDeque {
        private final char[] dat;
        private int head;
        private int tail;

        public MyDeque(int N) {
            this.dat = new char[2*N+1];
            this.head = N;
            this.tail = N;
        }


        public void push_front(char newItem) {
            dat[--head] = newItem;
        }

        public void push_back(char newItem) {
            dat[tail++] = newItem;
        }

        public void pop_front() {
            head++;
        }

        public void pop_back() {
            tail--;
        }

        public int size() {
            return tail - head;
        }

        public boolean empty() {
            return (tail - head) == 0;
        }

        public char front() {
            return dat[head];
        }

        public char back() {
            return dat[tail-1];
        }

    }

}