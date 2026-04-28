import java.io.*;
import java.util.*;

public class Main {

    static int N, M, K;
    static long[] arr;
    static long[] tree;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 수의 개수
        M = Integer.parseInt(st.nextToken()); // 변경 횟수
        K = Integer.parseInt(st.nextToken()); // 구간 합 구하는 횟수

        arr = new long[N + 1];
        tree = new long[N * 4];

        for (int i = 1; i <= N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        init(1, N, 1);

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());

            int command = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (command == 1) {
                update(1, N, 1, b, c);
            } else {
                long answer = query(1, N, 1, b, (int) c);
                sb.append(answer).append('\n');
            }
        }

        System.out.print(sb);
    }

    static long init(int start, int end, int node) {
        if (start == end) {
            return tree[node] = arr[start];
        }

        int mid = (start + end) / 2;

        return tree[node] =
                init(start, mid, node * 2)
              + init(mid + 1, end, node * 2 + 1);
    }

    static void update(int start, int end, int node, int index, long value) {
        if (index < start || index > end) {
            return;
        }

        if (start == end) {
            arr[index] = value;
            tree[node] = value;
            return;
        }

        int mid = (start + end) / 2;

        update(start, mid, node * 2, index, value);
        update(mid + 1, end, node * 2 + 1, index, value);

        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    static long query(int start, int end, int node, int left, int right) {
        if (right < start || end < left) {
            return 0;
        }

        if (left <= start && end <= right) {
            return tree[node];
        }

        int mid = (start + end) / 2;

        return query(start, mid, node * 2, left, right)
             + query(mid + 1, end, node * 2 + 1, left, right);
    }
}