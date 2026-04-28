import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static char[][] map;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static boolean[][][][] visited;

    static class State {
        int rr, rc; // red row, red col
        int br, bc; // blue row, blue col
        int depth;

        State(int rr, int rc, int br, int bc, int depth) {
            this.rr = rr;
            this.rc = rc;
            this.br = br;
            this.bc = bc;
            this.depth = depth;
        }
    }

    static class MoveResult {
        int r, c;
        int moveCount;
        boolean hole;

        MoveResult(int r, int c, int moveCount, boolean hole) {
            this.r = r;
            this.c = c;
            this.moveCount = moveCount;
            this.hole = hole;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M][N][M];

        int redR = 0;
        int redC = 0;
        int blueR = 0;
        int blueC = 0;

        for (int r = 0; r < N; r++) {
            String line = br.readLine();

            for (int c = 0; c < M; c++) {
                map[r][c] = line.charAt(c);

                if (map[r][c] == 'R') {
                    redR = r;
                    redC = c;
                    map[r][c] = '.';
                } else if (map[r][c] == 'B') {
                    blueR = r;
                    blueC = c;
                    map[r][c] = '.';
                }
            }
        }

        System.out.println(bfs(redR, redC, blueR, blueC));
    }

    static int bfs(int redR, int redC, int blueR, int blueC) {
        Deque<State> queue = new ArrayDeque<>();

        queue.offer(new State(redR, redC, blueR, blueC, 0));
        visited[redR][redC][blueR][blueC] = true;

        while (!queue.isEmpty()) {
            State cur = queue.poll();

            if (cur.depth >= 10) {
                continue;
            }

            for (int d = 0; d < 4; d++) {
                MoveResult red = move(cur.rr, cur.rc, d);
                MoveResult blue = move(cur.br, cur.bc, d);

                // 파란 구슬이 구멍에 빠지면 실패 상태
                if (blue.hole) {
                    continue;
                }

                // 파란 구슬은 안 빠지고 빨간 구슬만 빠지면 성공
                if (red.hole) {
                    return cur.depth + 1;
                }

                int nextRedR = red.r;
                int nextRedC = red.c;
                int nextBlueR = blue.r;
                int nextBlueC = blue.c;

                // 두 구슬이 같은 칸에 멈췄다면 더 많이 이동한 구슬을 한 칸 뒤로 뺀다
                if (nextRedR == nextBlueR && nextRedC == nextBlueC) {
                    if (red.moveCount > blue.moveCount) {
                        nextRedR -= dr[d];
                        nextRedC -= dc[d];
                    } else {
                        nextBlueR -= dr[d];
                        nextBlueC -= dc[d];
                    }
                }

                if (visited[nextRedR][nextRedC][nextBlueR][nextBlueC]) {
                    continue;
                }

                visited[nextRedR][nextRedC][nextBlueR][nextBlueC] = true;
                queue.offer(new State(nextRedR, nextRedC, nextBlueR, nextBlueC, cur.depth + 1));
            }
        }

        return -1;
    }

    static MoveResult move(int r, int c, int direction) {
        int moveCount = 0;

        while (true) {
            int nr = r + dr[direction];
            int nc = c + dc[direction];

            if (map[nr][nc] == '#') {
                break;
            }

            r = nr;
            c = nc;
            moveCount++;

            if (map[r][c] == 'O') {
                return new MoveResult(r, c, moveCount, true);
            }
        }

        return new MoveResult(r, c, moveCount, false);
    }
}