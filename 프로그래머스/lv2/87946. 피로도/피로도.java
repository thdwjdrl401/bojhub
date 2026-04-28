import java.util.*;
class Solution {
    int answer = 0;
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        dfs(k, dungeons, visited, 0);
        return answer;
    }
    
    private void dfs(int stamina, int[][] dungeons, boolean[] visited, int count){
        answer = Math.max(answer, count);
        
        for(int i = 0; i < dungeons.length; i++){
            int min = dungeons[i][0];
            int cost = dungeons[i][1];
            
            if(!visited[i] && stamina >= min){
                visited[i] = true;
                dfs(stamina - cost, dungeons, visited, count + 1);
                visited[i] = false;
            }
        }
    }
}