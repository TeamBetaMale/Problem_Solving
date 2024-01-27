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
        int n = Integer.parseInt(nm.split(" ")[0]);
        int m = Integer.parseInt(nm.split(" ")[1]);
        int[][] board = new int[n][m];

        for (int i = 0; i < n; i++) {
            String row = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = row.charAt(j) - '0';
            }
        }

        System.out.println(solve(n,m,board));
    }

    private static int solve(int n, int m, int[][] board) {
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visit = new boolean[n][m];
        int[][] distance = new int[n][m];
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};

        queue.add(new Point(0,0));
        visit[0][0] = true;
        distance[0][0] = 1;

        while (!queue.isEmpty()) {
            Point curr = queue.peek();
            queue.poll();
            for (int a = 0; a < 4; a++) {
                int nx = curr.x + dx[a];
                int ny = curr.y + dy[a];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (visit[nx][ny] || board[nx][ny] == 0) continue;
                queue.add(new Point(nx,ny));
                visit[nx][ny] = true;
                distance[nx][ny] = distance[curr.x][curr.y] + 1;
            }
        }

        return distance[n-1][m-1];
    }
}