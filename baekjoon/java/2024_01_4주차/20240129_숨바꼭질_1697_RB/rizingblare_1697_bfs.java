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
        int N = Integer.parseInt(nm.split(" ")[0]);
        int K = Integer.parseInt(nm.split(" ")[1]);

        System.out.println(solve(N,K));
    }

    private static int solve(int N, int K) {
        if (N == K) return 0;

        final int MAX_DISTANCE = 100000;

        int[] dist = new int[MAX_DISTANCE+1];
        boolean[] vis = new boolean[MAX_DISTANCE+1];

        vis[N] = true;
        dist[K] = -1;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);

        while (!queue.isEmpty()) {
            int curr = queue.peek();
            queue.poll();
            int[] next = {curr-1, curr+1, curr*2};
            for (int i = 0; i < 3; i++) {
                if (next[i] < 0 || next[i] > MAX_DISTANCE || vis[next[i]]) continue;
                if (next[i] == K) return dist[curr]+1;
                vis[next[i]] = true;
                dist[next[i]] = dist[curr]+1;
                queue.add(next[i]);
            }
        }
        return -1;
    }
}