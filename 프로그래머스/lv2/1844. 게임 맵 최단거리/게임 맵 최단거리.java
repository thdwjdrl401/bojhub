import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        int x = maps[0].length;
        int y = maps.length;
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0});
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            for(int i = 0; i < 4; i++){
                int curX = cur[0] + dx[i];
                int curY = cur[1] + dy[i];
                if(curX < 0 || curX >= x || curY < 0 || curY >= y) continue;
                if(maps[curY][curX] != 1) continue;

                maps[curY][curX] = maps[cur[1]][cur[0]] + 1;
                queue.offer(new int[]{curX, curY});
            }
        }
        for(int[] tx : maps){
            for(int ty : tx) System.out.print(ty + " ");
            System.out.println();
        }
        return maps[y - 1][x - 1] == 1 ? -1 : maps[y - 1][x - 1];
    }
}