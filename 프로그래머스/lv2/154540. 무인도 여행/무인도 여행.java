import java.util.*;

class Solution {
    public int[] solution(String[] maps) {
        int xSize = maps[0].length();
        int ySize = maps.length;
        
        int[] xMove = {-1, 0, 1, 0};
        int[] yMove = {0, -1, 0, 1};
        
        // 방문했는지 확인하는 변수
        boolean[][] visited = new boolean[ySize][xSize];
        // 결과
        List<Integer> resultList = new ArrayList<>();
        
        for(int y = 0; y < ySize; y++){
            for(int x = 0; x < xSize; x++){
                // 방문했거나 X면 PASS
                if(visited[y][x] || maps[y].charAt(x) == 'X') continue;
                
                int[] first = new int[]{x,y};
                visited[y][x] = true;
                Queue<int[]> que = new LinkedList<>();
                que.offer(first);
                int sum = Integer.parseInt(String.valueOf(maps[y].charAt(x)));

                while(!que.isEmpty()){
                    int[] now = que.poll();
                    int nowX = now[0];
                    int nowY = now[1];
                    
                    for(int i = 0; i < 4; i ++){
                        int dx = nowX + xMove[i];
                        int dy = nowY + yMove[i];
                        
                        if(dx < 0 || dx >= xSize || dy < 0 || dy >= ySize) continue;
                        if(visited[dy][dx] || maps[dy].charAt(dx) == 'X') continue;
                        
                        visited[dy][dx] = true;
                        que.offer(new int[]{dx, dy});
                        sum += Integer.parseInt(String.valueOf(maps[dy].charAt(dx)));
                    }
                }
                resultList.add(sum);
            }
        }
        if(resultList.isEmpty()) resultList.add(-1);
        Collections.sort(resultList);
        int[] answer = new int[resultList.size()];
        int k = 0;
        for (int v : resultList) answer[k++] = v;
    

        return answer;
    }
}