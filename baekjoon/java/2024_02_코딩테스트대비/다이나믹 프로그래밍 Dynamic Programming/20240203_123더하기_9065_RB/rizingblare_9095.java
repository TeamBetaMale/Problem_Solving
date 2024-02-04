import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int[] dp = new int[11];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i <= 10; i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }

        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            sb.append(dp[sc.nextInt()]).append("\n");
        }

        System.out.println(sb);
    }
}