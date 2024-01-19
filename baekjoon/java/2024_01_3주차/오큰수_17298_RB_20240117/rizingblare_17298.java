import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] origin_arr = arr.clone();

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            while (true) {
                if (!stack.empty()) {
                    if (arr[stack.peek()] < arr[i]) {
                        arr[stack.peek()] = arr[i];
                        stack.pop();
                    }
                    else {
                        stack.push(i);
                        break;
                    }
                }
                else {
                    stack.push(i);
                    break;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == origin_arr[i]) {
                arr[i] = -1;
            }
            sb.append(arr[i]).append(" ");
        }

        System.out.println(sb);
    }
}