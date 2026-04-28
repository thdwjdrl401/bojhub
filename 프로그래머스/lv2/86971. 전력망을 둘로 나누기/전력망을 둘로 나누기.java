import java.util.*;
class Solution {
    public int solution(int n, int[][] wires) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i ++) graph.add(new ArrayList<Integer>());
        for(int[] w : wires){
            int a = w[0];
            int b = w[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        int answer = 100;
        for(int[] w : wires){
            int count = bfsCount(n, graph, w[0], w[0], w[1]);
            int diff = Math.abs(n - 2 * count);
            answer = Math.min(answer, diff);
        }
        return answer;
    }
    
    private int bfsCount(int n, List<List<Integer>> graph, int start, int blockA, int blockB){
        boolean[] visited = new boolean[n+1];
        Deque<Integer> dq = new ArrayDeque<>();
        visited[start] = true;
        dq.offer(start);
        int count = 0;
        
        while(!dq.isEmpty()){
            int current = dq.poll();
            count++;
            for(int next : graph.get(current)){
                if((current == blockA && next == blockB) || (current == blockB) && (next == blockA)) continue;
                if(!visited[next]){
                    visited[next] = true;
                    dq.offer(next);
                }
            }
        }
        return count;
    }
}