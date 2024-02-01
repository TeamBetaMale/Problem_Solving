import java.io.*;
import java.util.*;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder sb = new StringBuilder();

    private static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        int N = sc.nextInt();
        int M = sc.nextInt();
        int V = sc.nextInt();

        graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph[u].add(v);
            graph[v].add(u);
        }

        for (int i = 1; i <= N; i++) {
            graph[i].sort(Comparator.naturalOrder());
        }

        doDFS(N,V);
        doBFS(N,V);

        System.out.println(sb);
    }

    private static void doDFS(int N, int V) {
        boolean vis[] = new boolean[N+1];
        dfs(V,vis);
        sb.append("\n");
    }

    private static void dfs(int curr, boolean[] vis) {
        sb.append(curr).append(" ");
        vis[curr] = true;

        for (int i : graph[curr]) {
            if (vis[i]) continue;
            dfs(i,vis);
        }
    }

    private static void doBFS(int N, int V) {
        boolean vis[] = new boolean[N+1];
        Queue<Integer> bfsQueue = new LinkedList<>();

        vis[V] = true;
        bfsQueue.add(V);

        while (!bfsQueue.isEmpty()) {
            int curr = bfsQueue.peek();
            bfsQueue.poll();
            sb.append(curr).append(" ");

            for (int i : graph[curr]) {
                if (vis[i]) continue;
                vis[i] = true;
                bfsQueue.add(i);
            }
        }

        sb.append("\n");

    }

}