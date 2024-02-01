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

        System.out.println(solve(N, graph));

    }

    private static int solve(int n, ArrayList<Integer>[] graph) {

        boolean[] vis = new boolean[n+1];
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (vis[i]) continue;
            cnt++;
            dfs(i,vis,graph);
        }
        return cnt;
    }

    private static void dfs(int i, boolean[] vis, ArrayList<Integer>[] graph) {
        vis[i] = true;
        for (int j : graph[i]) {
            if (vis[j]) continue;
            dfs(j,vis,graph);
        }
    }
}