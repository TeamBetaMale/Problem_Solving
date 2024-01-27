import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        String nm = br.readLine();
        int m = Integer.parseInt(nm.split(" ")[0]);
        int n = Integer.parseInt(nm.split(" ")[1]);
        int[][] board = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(row[j]);
            }
        }

        System.out.println(solve(n,m,board));
    }

    private static int solve(int n, int m, int[][] board) {
        Queue<Point> queue = new LinkedList<>();
        boolean[][] vis = new boolean[n][m];
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] != 1) continue;
                queue.add(new Point(i, j));
                vis[i][j] = true;
            }
        }

        while (!queue.isEmpty()) {
            Point curr = queue.peek();
            queue.poll();
            for (int a = 0; a < 4; a++) {
                int nx = curr.x + dx[a];
                int ny = curr.y + dy[a];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (board[nx][ny] == -1 || vis[nx][ny]) continue;
                board[nx][ny] = board[curr.x][curr.y] + 1;
                vis[nx][ny] = true;
                queue.add(new Point(nx, ny));
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0) return -1;
                max = Math.max(board[i][j], max);
            }
        }
        return max-1;
    }

}