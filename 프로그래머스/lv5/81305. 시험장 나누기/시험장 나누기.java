import java.util.*;

class Solution {
    int[][] links;
    int[] num;
    int n, root;
    int groups;

    public int solution(int k, int[] num, int[][] links) {
        this.num = num;
        this.links = links;
        this.n = num.length;

        // 1) 루트 찾기 (자식으로 한 번도 등장하지 않는 노드)
        boolean[] isChild = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (links[i][0] != -1) isChild[links[i][0]] = true;
            if (links[i][1] != -1) isChild[links[i][1]] = true;
        }
        root = 0;
        for (int i = 0; i < n; i++) if (!isChild[i]) { root = i; break; }

        // 2) cap 범위: [가장 큰 단일 노드 인원, 전체 합]
        long lo = 0, hi = 0;
        for (int v : num) { lo = Math.max(lo, v); hi += v; }

        // 3) 이분 탐색: cap(한 그룹 최대 인원)을 최소화
        while (lo < hi) {
            long mid = (lo + hi) >>> 1;
            groups = 0;
            long carry = dfs(root, mid);       // 루트 쪽으로 '미완 그룹'의 합 반환
            int need = groups + (carry > 0 ? 1 : 0); // 남아있는 carry도 최종 1그룹으로 계산
            if (need <= k) hi = mid;           // 더 줄일 수 있음
            else lo = mid + 1;                 // cap이 작아 그룹이 너무 많이 생김 → 키움
        }
        return (int) lo;
    }

    // dfs(u, cap): u 서브트리에서 cap 넘지 않게 최대한 합친 뒤
    //              부모로 '미완 그룹'의 인원 합(<=cap)을 넘김.
    //              cap 때문에 끊어진 서브트리는 groups에 누적.
    private long dfs(int u, long cap) {
        if (u == -1) return 0L;

        long L = dfs(links[u][0], cap);
        long R = dfs(links[u][1], cap);
        long here = num[u];

        long sum = L + R + here;
        if (sum <= cap) return sum;            // 둘 다 붙여도 cap 이하 → 그대로 올림

        // 세 가지 케이스로 자르기(탐욕):
        // 1) 둘 중 하나만 끊으면 되는 경우 → 더 큰 쪽을 끊고 작은 쪽+here를 올림
        if (L + here <= cap && R + here <= cap) {
            groups++;                          // 큰 쪽은 완성 그룹으로 확정
            return Math.min(L, R) + here;
        }
        // 2) 한 쪽만 붙일 수 있는 경우 → 못 붙이는 한 쪽은 끊음
        if (L + here <= cap) { groups++; return L + here; }
        if (R + here <= cap) { groups++; return R + here; }

        // 3) 어느 쪽과도 합쳐도 cap 초과 → 양쪽 다 끊고 현재 노드만 올림
        groups += 2;
        return here;                           // here는 cap 이상이 아님(초기 lo에서 보장)
    }
}
