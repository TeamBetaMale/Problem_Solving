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


    private static class MyQueue {
        private final int[] dat;
        private int head;
        private int tail;

        public MyQueue(int N) {
            this.dat = new int[N];
            this.head = 0;
            this.tail = 0;
        }


        public void push(int newItem) {
            dat[tail++] = newItem;
        }

        public void pop() {
            head++;
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

    private static class MyPrompt {
        private final MyQueue queue;

        public MyPrompt(int N) {
            this.queue = new MyQueue(N);
        }

        public void getCommand(String commmandString) {
            String[] cmdAndItem = commmandString.split(" ");

            switch (cmdAndItem[0]) {
                case "push":
                    int newItem = Integer.parseInt(cmdAndItem[1]);
                    queue.push(newItem);
                    break;
                case "pop":
                    if (queue.empty()) {
                        sb.append(-1).append("\n");
                        break;
                    }
                    sb.append(queue.front()).append("\n");
                    queue.pop();
                    break;
                case "size":
                    sb.append(queue.size()).append("\n");
                    break;
                case "empty":
                    if (queue.empty()) {
                        sb.append(1).append("\n");
                        break;
                    }
                    sb.append(0).append("\n");
                    break;
                case "front":
                    if (queue.empty()) {
                        sb.append(-1).append("\n");
                        break;
                    }
                    sb.append(queue.front()).append("\n");
                    break;
                case "back":
                    if (queue.empty()) {
                        sb.append(-1).append("\n");
                        break;
                    }
                    sb.append(queue.back()).append("\n");
                    break;
            }
        }
    }
}