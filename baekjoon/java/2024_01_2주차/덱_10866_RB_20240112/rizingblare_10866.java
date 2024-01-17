import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());
        MyPrompt prompt = new MyPrompt(N);

        for (int i = 0; i < N; i++) {
            prompt.getCommand(br.readLine());
        }


        System.out.println(sb);
    }


    private static class MyPrompt {

        private final MyDeque deque;

        public MyPrompt(int N) {
            this.deque = new MyDeque(N);
        }

        public void getCommand(String cmdAndItem) {
            String command = cmdAndItem.split(" ")[0];

            switch (command) {

                case "push_front":
                    deque.push_front(convertCommand(cmdAndItem));
                    break;
                case "push_back":
                    deque.push_back(convertCommand(cmdAndItem));
                    break;
                case "pop_front":
                    if (deque.empty()) sb.append(-1).append("\n");
                    else {
                        sb.append(deque.front()).append("\n");
                        deque.pop_front();
                    }
                    break;
                case "pop_back":
                    if (deque.empty()) sb.append(-1).append("\n");
                    else {
                        sb.append(deque.back()).append("\n");
                        deque.pop_back();
                    }
                    break;
                case "size":
                    sb.append(deque.size()).append("\n");
                    break;
                case "empty":
                    if (deque.empty()) sb.append(1).append("\n");
                    else sb.append(0).append("\n");
                    break;
                case "front":
                    if (deque.empty()) sb.append(-1).append("\n");
                    else sb.append(deque.front()).append("\n");
                    break;
                case "back":
                    if (deque.empty()) sb.append(-1).append("\n");
                    else sb.append(deque.back()).append("\n");
                    break;
            }
        }

        private int convertCommand(String cmdAndItem) {
            return Integer.parseInt(cmdAndItem.split(" ")[1]);
        }
    }

    private static class MyDeque {
        private final int[] dat;
        private int head;
        private int tail;

        public MyDeque(int N) {
            this.dat = new int[2*N+1];
            this.head = N;
            this.tail = N;
        }


        public void push_front(int newItem) {
            dat[--head] = newItem;
        }

        public void push_back(int newItem) {
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

        public int front() {
            return dat[head];
        }

        public int back() {
            return dat[tail-1];
        }

    }

}