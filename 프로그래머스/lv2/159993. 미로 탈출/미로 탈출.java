import java.util.*;
class Solution {
    public int solution(String[] maps) {
        int[] start = new int [3], lever = new int [3], end = new int [3];
        for(int i = 0; i < maps.length; i++){
            for(int j = 0; j < maps[0].length(); j++){
                char ch = maps[i].charAt(j);
                if(ch == 'S'){
                    start[0] = i;
                    start[1] = j;
                    start[2] = 0;
                }
                if(ch == 'E'){
                    end[0] = i;
                    end[1] = j;
                    end[2] = 0;
                }
                if(ch == 'L'){
                    lever[0] = i;
                    lever[1] = j;
                    lever[2] = 0;
                }
            }
        }
        // start, lever, end 좌표 확인
        int startToLever = countingTime(start, lever, maps);
        if(startToLever == -1) return -1;
        int leverToEnd = countingTime(lever, end, maps);
        if(leverToEnd == -1) return -1;
        return startToLever + leverToEnd;
    }
    
    private int countingTime(int[] start, int[] end, String[] maps){
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        // int[][] mapInt = new int[maps.length][maps[0].length()];
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(start);
        visited[start[0]][start[1]] = true;
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        while(!dq.isEmpty()){
            int[] cur = dq.poll();
            int x = cur[0];
            int y = cur[1];
            int dis = cur[2];
            
            if(x == end[0] && y == end[1]) return dis;

            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx < 0 || ny < 0 || nx >= maps.length || ny >= maps[0].length()) continue;
                if(visited[nx][ny] || maps[nx].charAt(ny) == 'X') continue;
                
                dq.offer(new int[]{nx, ny, dis + 1});
                visited[nx][ny] = true;
            }
        }
        //  for(int[] i : mapInt){
        //     for(int j : i) System.out.print(j + " ");
        //     System.out.println();
        // }
        return -1;
    }
}