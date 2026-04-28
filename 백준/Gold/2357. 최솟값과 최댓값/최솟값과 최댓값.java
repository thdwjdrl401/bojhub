import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] arr;
    static int[] minTree;
    static int[] maxTree;

    static final int INF = Integer.MAX_VALUE;
    static final int NEG_INF = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];
        minTree = new int[N * 4];
        maxTree = new int[N * 4];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        init(1, N, 1);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            int minValue = queryMin(1, N, 1, left, right);
            int maxValue = queryMax(1, N, 1, left, right);

            sb.append(minValue).append(' ').append(maxValue).append('\n');
        }

        System.out.print(sb);
    }

    static void init(int start, int end, int node) {
        if (start == end) {
            minTree[node] = arr[start];
            maxTree[node] = arr[start];
            return;
        }

        int mid = (start + end) / 2;

        init(start, mid, node * 2);
        init(mid + 1, end, node * 2 + 1);

        minTree[node] = Math.min(minTree[node * 2], minTree[node * 2 + 1]);
        maxTree[node] = Math.max(maxTree[node * 2], maxTree[node * 2 + 1]);
    }

    static int queryMin(int start, int end, int node, int left, int right) {
        if (right < start || end < left) {
            return INF;
        }

        if (left <= start && end <= right) {
            return minTree[node];
        }

        int mid = (start + end) / 2;

        return Math.min(
            queryMin(start, mid, node * 2, left, right),
            queryMin(mid + 1, end, node * 2 + 1, left, right)
        );
    }

    static int queryMax(int start, int end, int node, int left, int right) {
        if (right < start || end < left) {
            return NEG_INF;
        }

        if (left <= start && end <= right) {
            return maxTree[node];
        }

        int mid = (start + end) / 2;

        return Math.max(
            queryMax(start, mid, node * 2, left, right),
            queryMax(mid + 1, end, node * 2 + 1, left, right)
        );
    }
}