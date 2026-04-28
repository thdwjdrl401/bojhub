import java.util.*;
class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[computers.length];
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i = 0; i < computers.length; i++){
            if(visited[i]) continue;
            dq.offer(i);
            while(!dq.isEmpty()){
                int cur = dq.poll();
                for(int j = 0; j < n; j++){
                    int target = computers[cur][j];
                    if(cur == j || visited[j] || target == 0) continue;
                    dq.offer(j);
                    visited[j] = true;
                }
            }
            answer++;
        }
        return answer;
    }
}
