import java.util.*;
class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        int[][] coordinate = new int[105][105];
        characterX *= 2;
        characterY *= 2;
        itemX *= 2;
        itemY *= 2;
        Deque<Integer[]> dq = new ArrayDeque<>();
        for(int i = 0; i < rectangle.length; i++){
            for(int j = 0; j < 4; j++) rectangle[i][j] *= 2;
            int leftBottomX = rectangle[i][0];
            int leftBottomY = rectangle[i][1];
            int rightTopX = rectangle[i][2];
            int rightTopY = rectangle[i][3];
            for(int x = leftBottomX; x <= rightTopX; x++){
                coordinate[leftBottomY][x] = 1;
                coordinate[rightTopY][x] = 1;
            }
            for(int y = leftBottomY; y <= rightTopY; y++){
                coordinate[y][leftBottomX] = 1;
                coordinate[y][rightTopX] = 1;
            }
        }
        
        for(int[] r : rectangle){
            int x1 = r[0], y1 = r[1], x2 = r[2], y2 = r[3];
            for(int y = y1 + 1; y < y2; y++){
                for(int x = x1 + 1; x < x2; x++){
                    coordinate[y][x] = 0;
                }
            }
        }
        
        boolean[][] visited = new boolean[105][105];
        Queue<int[]> q = new ArrayDeque<>();
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        q.offer(new int[]{characterY, characterX, 0});
        visited[characterY][characterX] = true;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int y = cur[0], x = cur[1], dist = cur[2];
            
            if(x == itemX && y == itemY){
                answer = dist / 2;
                break;
            }
            
            for(int dir = 0; dir < 4; dir++){
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                
                if(nx < 0 || ny < 0 || nx > 100 || ny > 100) continue;
                if(coordinate[ny][nx] != 1) continue;
                if(visited[ny][nx]) continue;
                
                visited[ny][nx] = true;
                q.offer(new int[]{ny, nx, dist + 1});
            }
        }
        
        return answer;
    }
}