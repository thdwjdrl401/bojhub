import java.io.*;
import java.util.*;

public class Main {
    static int[][] map = new int[10][10];
    static boolean[][] covered = new boolean[10][10];
    static int[] left = {0, 5, 5, 5, 5, 5};
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int r = 0; r < 10; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0; c < 10; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);
        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }

    static void dfs(int used) {
        if (used >= result) return;

        int[] next = findFirst();
        if (next == null) {
            result = Math.min(result, used);
            return;
        }

        int r = next[0], c = next[1];

        for (int size = 5; size >= 1; size--) {
            if (left[size] == 0) continue;
            if (!canCover(r, c, size)) continue;

            cover(r, c, size, true);
            left[size]--;
            dfs(used + 1);
            left[size]++;
            cover(r, c, size, false);
        }
    }

    static int[] findFirst() {
        for (int r = 0; r < 10; r++) {
            for (int c = 0; c < 10; c++) {
                if (map[r][c] == 1 && !covered[r][c]) {
                    return new int[]{r, c};
                }
            }
        }
        return null;
    }

    static boolean canCover(int r, int c, int size) {
        if (r + size > 10 || c + size > 10) return false;

        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (map[i][j] != 1) return false;
                if (covered[i][j]) return false;
            }
        }
        return true;
    }

    static void cover(int r, int c, int size, boolean val) {
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                covered[i][j] = val;
            }
        }
    }
}
