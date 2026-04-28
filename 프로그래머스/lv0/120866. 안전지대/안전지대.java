class Solution {
    public int solution(int[][] board) {
        int n = board.length;
        boolean[][] danger = new boolean[n][n];

        // 8방향 + 자기 자신(총 9방향) 오프셋
        int[] dx = {-1,-1,-1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1,-1, 1,-1, 0, 1};

        // 1) 지뢰 주변 표시
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    danger[i][j] = true; // 지뢰 칸 자체도 위험
                    for (int k = 0; k < 8; k++) {
                        int ni = i + dx[k], nj = j + dy[k];
                        if (0 <= ni && ni < n && 0 <= nj && nj < n) {
                            danger[ni][nj] = true;
                        }
                    }
                }
            }
        }

        // 2) 안전 칸 세기
        int safe = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0 && !danger[i][j]) safe++;
            }
        }
        return safe;
    }
}
