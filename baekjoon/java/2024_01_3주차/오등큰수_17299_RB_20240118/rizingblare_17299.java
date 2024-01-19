import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());

        int[] input_array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] counter_array = new int[10000001];

        for (int i : input_array) {
            counter_array[i]++;
        }
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            while (!stack.empty() && counter_array[input_array[stack.peek()]] < counter_array[input_array[i]]) {
                    input_array[stack.peek()] = input_array[i];
                    stack.pop();
            }
            stack.push(i);
        }

        while (!stack.empty()) {
            input_array[stack.peek()] = -1;
            stack.pop();
        }

        for (int i = 0; i < N; i++) {
            sb.append(input_array[i]).append(" ");
        }

        System.out.println(sb);
    }
}