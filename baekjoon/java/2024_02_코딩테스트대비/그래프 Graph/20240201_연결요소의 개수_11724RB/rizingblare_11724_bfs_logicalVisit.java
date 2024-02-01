import java.io.*;
import java.util.*;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final Scanner sc = new Scanner(System.in);
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int N = sc.nextInt();
        int M = sc.nextInt();

        ArrayList<Integer>[] graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph[u].add(v);
            graph[v].add(u);
        }

        System.out.println(solve(N,M,graph));

    }

    private static int solve(int n, int m, ArrayList<Integer>[] graph) {

        boolean[] vis = new boolean[n+1];
        Queue<Integer> queue = new LinkedList<>();

        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (vis[i]) continue;
            cnt++;
            queue.add(i);

            while (!queue.isEmpty()) {
                int curr = queue.peek();
                queue.poll();
                if (vis[curr]) continue;
                vis[curr] = true;

                for (int j : graph[curr]) {
                    if (vis[j]) continue;
                    queue.add(j);
                }
            }
        }
        return cnt;
    }
}