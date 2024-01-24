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
        int r = Integer.parseInt(nm.split(" ")[0]);
        int c = Integer.parseInt(nm.split(" ")[1]);
        char[][] board = new char[r][c];

        for (int i = 0; i < r; i++) {
            String row = br.readLine();
            for (int j = 0; j < c; j++) {
                board[i][j] = row.charAt(j);
            }
        }

        System.out.println(solve(r,c,board));
    }

    private static String solve(int r, int c, char[][] board) {
        Queue<Point> queue = new LinkedList<>();
        int[][] jDist = new int[r][c];
        int[][] fDist = new int[r][c];
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == 'F') {
                    fDist[i][j] = 1;
                    queue.add(new Point(i,j));
                }
            }
        }

        while (!queue.isEmpty()) {
            Point curr = queue.peek();
            queue.poll();
            for (int a = 0; a < 4; a++) {
                int nx = curr.x + dx[a];
                int ny = curr.y + dy[a];
                if (nx < 0 || nx >= r || ny < 0 || ny >= c) continue;
                if (board[nx][ny] == '#' || fDist[nx][ny] > 0) continue;
                fDist[nx][ny] = fDist[curr.x][curr.y] + 1;
                queue.add(new Point(nx, ny));
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == 'J') {
                    jDist[i][j] = 1;
                    queue.add(new Point(i,j));
                }
            }
        }

        while (!queue.isEmpty()) {
            Point curr = queue.peek();
            queue.poll();
            for (int a = 0; a < 4; a++) {
                int nx = curr.x + dx[a];
                int ny = curr.y + dy[a];
                if (nx < 0 || nx >= r || ny < 0 || ny >= c) return String.valueOf(jDist[curr.x][curr.y]);
                if (board[nx][ny] == '#' || jDist[nx][ny] > 0) continue;
                if (fDist[nx][ny] != 0 && jDist[curr.x][curr.y] + 1 >= fDist[nx][ny]) continue;
                jDist[nx][ny] = jDist[curr.x][curr.y] + 1;
                queue.add(new Point(nx, ny));
            }
        }

        return "IMPOSSIBLE";
    }

}