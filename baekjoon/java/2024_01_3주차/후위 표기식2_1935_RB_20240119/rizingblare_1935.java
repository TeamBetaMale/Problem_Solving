import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());
        String command = br.readLine();

        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        Stack<Double> stack = new Stack<>();
        for (char c : command.toCharArray()) {
            if ('A' <= c && c <= 'Z') {
                stack.push((double) array[c - 65]);
            }
            else {
                double backward = stack.pop();
                double forward = stack.pop();

                if (c == '+') {
                    stack.push(forward + backward);
                }

                if (c == '-') {

                    stack.push(forward - backward);
                }

                if (c == '*') {
                    stack.push(forward * backward);
                }

                if (c == '/') {
                    stack.push(forward / backward);
                }
            }
        }
        System.out.printf("%.2f", stack.peek());
    }
}