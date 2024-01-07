import java.util.Scanner;
import java.util.Stack;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final StringBuffer sb = new StringBuffer();

    public static void main(String[] args) {

        int n = scanner.nextInt();
        Stack<Integer> stack = new Stack<>();

        requestCommand(n, stack);

        System.out.println(sb);
    }

    private static void requestCommand(int n, Stack<Integer> stack) {
        for (int i = 0; i < n; i++) {
            String cmd = scanner.next();

            switch (cmd) {
                case "push":
                    int pushItem = scanner.nextInt();
                    stack.push(pushItem);
                    break;

                case "pop":
                    if (stack.isEmpty()){
                        sb.append(-1).append("\n");
                        break;
                    }
                    int popItem = stack.pop();
                    sb.append(popItem).append("\n");
                    break;

                case "size":
                    int size = stack.size();
                    sb.append(size).append("\n");
                    break;

                case "empty":
                    if (stack.isEmpty()){
                        sb.append(1).append("\n");
                        break;
                    }
                    sb.append(0).append("\n");
                    break;

                case "top":
                    if (stack.isEmpty()){
                        sb.append(-1).append("\n");
                        break;
                    }
                    int topItem = stack.peek();
                    sb.append(topItem).append("\n");
                    break;
            }
        }
    }
}