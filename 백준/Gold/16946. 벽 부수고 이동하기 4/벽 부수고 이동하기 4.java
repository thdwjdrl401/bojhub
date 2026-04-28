import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] map;
    static int[] groupSize;
    static int groupId = 2;

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        groupSize = new int[N * M + 2];

        for (int r = 0; r < N; r++) {
            String line = br.readLine();
            for (int c = 0; c < M; c++) {
                map[r][c] = line.charAt(c) - '0';
            }
        }

        // 1. 빈 칸 영역 그룹화
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (map[r][c] == 0) {
                    groupSize[groupId] = bfs(r, c, groupId);
                    groupId++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        // 2. 벽마다 인접한 서로 다른 그룹 크기 합산
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {

                if (map[r][c] != 1) {
                    sb.append(0);
                    continue;
                }

                int sum = 1;
                int[] used = new int[4];
                int usedCount = 0;

                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    if (!check(nr, nc)) continue;
                    if (map[nr][nc] == 1) continue;

                    int adjacentGroupId = map[nr][nc];

                    boolean duplicated = false;
                    for (int k = 0; k < usedCount; k++) {
                        if (used[k] == adjacentGroupId) {
                            duplicated = true;
                            break;
                        }
                    }

                    if (duplicated) continue;

                    used[usedCount++] = adjacentGroupId;
                    sum += groupSize[adjacentGroupId];
                }

                sb.append(sum % 10);
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }

    static int bfs(int startR, int startC, int id) {
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {startR, startC});

        map[startR][startC] = id;

        int count = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];

            count++;

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (!check(nr, nc)) continue;
                if (map[nr][nc] != 0) continue;

                map[nr][nc] = id;
                queue.offer(new int[] {nr, nc});
            }
        }

        return count;
    }

    static boolean check(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }
}