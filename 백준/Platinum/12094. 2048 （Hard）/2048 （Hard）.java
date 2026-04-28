import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] map;
    static int answer = 0;
    static final int LIMIT = 10;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                answer = Math.max(answer, map[i][j]);
            }
        }

        dfs(0, map);
        System.out.println(answer);
    }

    static void dfs(int depth, int[][] board) {
        int curMax = getMax(board);
        answer = Math.max(answer, curMax);

        if (depth == LIMIT) return;

        int remain = LIMIT - depth;
        if (curMax * (1 << remain) <= answer) return;

        for (int dir = 0; dir < 4; dir++) {
            int[][] next = copy(board);
            move(next, dir);

            if (isSame(board, next)) continue;

            dfs(depth + 1, next);
        }
    }

    static int getMax(int[][] board) {
        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                max = Math.max(max, board[i][j]);
            }
        }
        return max;
    }

    static int[][] copy(int[][] board) {
        int[][] result = new int[N][N];
        for (int i = 0; i < N; i++) {
            result[i] = board[i].clone();
        }
        return result;
    }

    static boolean isSame(int[][] a, int[][] b) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (a[i][j] != b[i][j]) return false;
            }
        }
        return true;
    }

    static int[] merge(int[] line) {
        int[] temp = new int[N];
        int len = 0;

        for (int i = 0; i < N; i++) {
            if (line[i] != 0) temp[len++] = line[i];
        }

        int[] result = new int[N];
        int idx = 0;

        for (int i = 0; i < len; i++) {
            if (i + 1 < len && temp[i] == temp[i + 1]) {
                result[idx++] = temp[i] * 2;
                i++;
            } else {
                result[idx++] = temp[i];
            }
        }

        return result;
    }

    static void move(int[][] board, int dir) {
        if (dir == 0) { // 위
            for (int c = 0; c < N; c++) {
                int[] line = new int[N];
                for (int r = 0; r < N; r++) {
                    line[r] = board[r][c];
                }

                int[] merged = merge(line);

                for (int r = 0; r < N; r++) {
                    board[r][c] = merged[r];
                }
            }
        } else if (dir == 1) { // 오른쪽
            for (int r = 0; r < N; r++) {
                int[] line = new int[N];
                for (int c = 0; c < N; c++) {
                    line[c] = board[r][N - 1 - c];
                }

                int[] merged = merge(line);

                for (int c = 0; c < N; c++) {
                    board[r][N - 1 - c] = merged[c];
                }
            }
        } else if (dir == 2) { // 아래
            for (int c = 0; c < N; c++) {
                int[] line = new int[N];
                for (int r = 0; r < N; r++) {
                    line[r] = board[N - 1 - r][c];
                }

                int[] merged = merge(line);

                for (int r = 0; r < N; r++) {
                    board[N - 1 - r][c] = merged[r];
                }
            }
        } else { // 왼쪽
            for (int r = 0; r < N; r++) {
                int[] line = new int[N];
                for (int c = 0; c < N; c++) {
                    line[c] = board[r][c];
                }

                int[] merged = merge(line);

                for (int c = 0; c < N; c++) {
                    board[r][c] = merged[c];
                }
            }
        }
    }
}