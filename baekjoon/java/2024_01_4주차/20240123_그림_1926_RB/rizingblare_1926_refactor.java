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
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < row.length; j++) {
                board[i][j] = Integer.parseInt(row[j]);
            }
        }
        int[] result = solve(n,m,board);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }

    private static int[] solve(int n, int m, int[][] board) {
        int[] result = new int[2];
        boolean[][] visit = new boolean[n][m];
        Queue<Point> bfsQ = new LinkedList<>();
        int[] dx = {0,1,-1,0};
        int[] dy = {1,0,0,-1};

        int cnt = 0;
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visit[i][j] && board[i][j] == 1) {
                    cnt++;
                    bfsQ.add(new Point(i,j));
                    visit[i][j] = true;
                    int area = 0;
                    while (!bfsQ.isEmpty()) {
                        area++;
                        Point curr = bfsQ.peek();
                        for (int a = 0; a < 4; a++) {
                            int nx = curr.x + dx[a];
                            int ny = curr.y + dy[a];
                            if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                            if (visit[nx][ny] || board[nx][ny] == 0) continue;
                            bfsQ.add(new Point(nx,ny));
                            visit[nx][ny] = true;
                        }
                        bfsQ.poll();
                    }
                    maxArea = Math.max(area, maxArea);
                }
            }
        }

        result[0] = cnt;
        result[1] = maxArea;

        return result;
    }
}