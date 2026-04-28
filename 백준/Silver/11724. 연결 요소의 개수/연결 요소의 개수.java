import java.io.*;
import java.util.*;

public class Main {
    static int N, M;

    // 인접리스트 (배열로 구현)
    static int[] head;      // 각 정점의 첫 간선 인덱스
    static int[] to;        // 간선이 향하는 정점
    static int[] next;      // 같은 정점에서의 다음 간선 인덱스
    static int edgeIdx = 0;

    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        N = fs.nextInt();
        M = fs.nextInt();

        head = new int[N + 1];
        Arrays.fill(head, -1);

        // 무향이므로 간선 2M개
        to = new int[2 * M];
        next = new int[2 * M];

        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            int u = fs.nextInt();
            int v = fs.nextInt();
            addEdge(u, v);
            addEdge(v, u);
        }

        int result = 0;

        // BFS용 큐 (배열)
        int[] q = new int[N];
        for (int i = 1; i <= N; i++) {
            if (visited[i]) continue;
            result++;

            int front = 0, back = 0;
            q[back++] = i;
            visited[i] = true;

            while (front < back) {
                int cur = q[front++];

                for (int e = head[cur]; e != -1; e = next[e]) {
                    int nx = to[e];
                    if (visited[nx]) continue;
                    visited[nx] = true;
                    q[back++] = nx;
                }
            }
        }

        System.out.println(result);
    }

    static void addEdge(int u, int v) {
        to[edgeIdx] = v;
        next[edgeIdx] = head[u];
        head[u] = edgeIdx++;
    }

    // 빠른 입력 (StringTokenizer보다 빠른 편)
    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        FastScanner(InputStream is) { in = is; }

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c;
            do c = read(); while (c <= ' '); // skip spaces
            int sign = 1;
            if (c == '-') { sign = -1; c = read(); }
            int val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }
    }
}
