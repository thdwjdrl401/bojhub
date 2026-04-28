import java.util.*;
class Solution {
    public int solution(String[] board) {
        int maxY = board.length;
        int maxX = board[0].length();
        boolean[][] visited = new boolean[maxY][maxX];
        int[] rPoint = new int[3], gPoint = new int[3];
        for(int y = 0; y < maxY; y++){
            for(int x = 0; x < maxX; x++){
                char ch = board[y].charAt(x);
                if(ch == 'R'){
                    rPoint[0] = y;
                    rPoint[1] = x;
                }
                if(ch == 'G'){
                    gPoint[0] = y;
                    gPoint[1] = x;
                }
            }
        }
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(rPoint);
        visited[rPoint[0]][rPoint[1]] = true;
        while(!dq.isEmpty()){
            int[] cur = dq.poll();
            int y = cur[0];
            int x = cur[1];
            int d = cur[2];
            if(y == gPoint[0] && x == gPoint[1]) return d;
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                int count = 0;
                while(nx >= 0 && nx < maxX && ny >= 0 && ny < maxY && board[ny].charAt(nx) != 'D'){
                    count++;
                    nx += dx[i];
                    ny += dy[i];
                }
                if(count == 0) continue;
                nx -= dx[i];
                ny -= dy[i];
                if(nx < 0 || nx >= maxX || ny < 0 || ny >= maxY) continue;
                if(visited[ny][nx]) continue;
                visited[ny][nx] = true;
                dq.offer(new int[]{ny, nx, d+1});
            }
        }
        return -1;
    }
}