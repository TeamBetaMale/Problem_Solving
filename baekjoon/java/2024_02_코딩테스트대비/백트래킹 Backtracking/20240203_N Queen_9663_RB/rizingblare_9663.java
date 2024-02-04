import java.util.Scanner;

public class Main {

    private static final Scanner sc = new Scanner(System.in);
    private static final StringBuilder sb = new StringBuilder();

    private static int n;
    private static int cnt = 0;
    private static boolean[][] arr;

    private static boolean isAvailable(int x, int y) {
        for (int i = 0; i < n; i++) {
            if (arr[x][i]) return false;
        }
        for (int i = 0; i < n; i++) {
            if (arr[i][y]) return false;
        }
        int[] dx = {-1,-1,1,1};
        int[] dy = {1,-1,1,-1};

        for (int i = 0 ; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                if (x + dx[j] * i < 0 || x + dx[j] * i >= n || y + dy[j] * i < 0 || y + dy[j] * i >= n) continue;
                if (arr[x + dx[j] * i][y + dy[j] * i]) return false;
            }
        }

        return true;
    }

    private static void backtrack(int x, int y, int depth) {
        if (depth == n) {
            cnt += 1;
            return;
        }

        for (int i = x; i < n; i++) {
            for (int j = y; j < n; j++) {
                if (!isAvailable(i,j)) continue;
                sb.append("depth: " + depth + " (" + i + "," + j + ")\n");
                arr[i][j] = true;
                backtrack(i+1, j+1, depth+1);
                arr[i][j] = false;
            }
        }
    }


    public static void main(String[] args) {
        n = sc.nextInt();
        arr = new boolean[n][n];

        backtrack(0,0,0);
        System.out.println(sb);
        System.out.println(cnt);
    }
}