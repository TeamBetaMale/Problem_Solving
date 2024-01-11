import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        String command = br.readLine();
        int N = Integer.parseInt(command.split(" ")[0]);
        int K = Integer.parseInt(command.split(" ")[1]);

        MyQueue circle = new MyQueue(N*N);

        for (int i = 0; i < N; i++) {
            circle.push(i+1);
        }

        sb.append("<");
        int cnt = 0;
        while (!circle.empty()){
            cnt++;
            int tmp = circle.front();
            circle.pop();
            if (cnt % K == 0) {
                sb.append(tmp);
                if (!circle.empty()){
                    sb.append(", ");
                }
            }
            else {
                circle.push(tmp);
            }

        }
        sb.append(">");

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
}