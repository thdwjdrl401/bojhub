import java.io.*;
import java.util.*;

public class Main {

    static int N, M, K;
    static int[] parent;
    static int[] candy;
    static int[] groupSize;
    static int[] groupCandy;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 아이 수
        M = Integer.parseInt(st.nextToken()); // 친구 관계 수
        K = Integer.parseInt(st.nextToken()); // 울음 조건 인원 수

        parent = new int[N + 1];
        candy = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            candy[i] = Integer.parseInt(st.nextToken());
            parent[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            union(a, b);
        }

        groupSize = new int[N + 1];
        groupCandy = new int[N + 1];

        // 각 루트 그룹에 인원 수와 사탕 수 합산
        for (int i = 1; i <= N; i++) {
            int root = find(i);
            groupSize[root]++;
            groupCandy[root] += candy[i];
        }

        // dp[j] = j명을 데려갔을 때 얻을 수 있는 최대 사탕 수
        int[] dp = new int[K];

        for (int i = 1; i <= N; i++) {
            if (groupSize[i] == 0) continue;

            int size = groupSize[i];
            int value = groupCandy[i];

            for (int j = K - 1; j >= size; j--) {
                dp[j] = Math.max(dp[j], dp[j - size] + value);
            }
        }

        System.out.println(dp[K - 1]);
    }

    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB) return;

        parent[rootB] = rootA;
    }
}