import java.util.Scanner;

public class Main {

    private static final Scanner sc = new Scanner(System.in);
    private static final StringBuilder sb = new StringBuilder();

    private static int n;
    private static int m;
    private static int[] arr;
    private static boolean[] isused;


    private static void backtrack(int k) {
        if (k == m) {
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!isused[i]) {
                arr[k] = i;
                isused[i] = true;
                backtrack(k+1);
                isused[i] = false;
            }
        }
    }


    public static void main(String[] args) {
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[m];
        isused = new boolean[n+1];

        backtrack(0);
        System.out.println(sb);
    }
}