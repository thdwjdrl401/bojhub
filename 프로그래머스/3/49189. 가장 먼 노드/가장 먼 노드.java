import java.util.*;
class Solution {
    public int solution(int n, int[][] edge) {
        boolean[] visited = new boolean[n + 1];
        List<List<Integer>> node = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            node.add(new ArrayList<>());
        }
        for(int i = 0; i < edge.length; i++){
            int[] curEdge = edge[i];
            node.get(curEdge[0]).add(curEdge[1]);
            node.get(curEdge[1]).add(curEdge[0]);
        }
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[]{1, 0});
        visited[1] = true;
        List<Integer> result = new ArrayList<>();
        result.add(1);
        while(!dq.isEmpty()){
            int[] cur = dq.poll();
            for(int next : node.get(cur[0])){
                if(visited[next]) continue;
                dq.offer(new int[]{next, cur[1] + 1});
                visited[next] = true;
                
                if(result.size() <= cur[1] + 1){
                    result.add(0);
                }
                Integer curCount = result.get(cur[1] + 1);
                result.set(cur[1] + 1, curCount+1);
                System.out.print(next + " " + (cur[1] + 1) + "  ");
            }
            System.out.println();
        }
        for(int x : result){
            System.out.print(x + " ");
        }
        // for(int i = 0; i <= n; i++){
        //     System.out.print(i + ":");
        //     for(int c : node.get(i)){
        //         System.out.print(c + " ");
        //     }
        //     System.out.println();
        // }
        return result.get(result.size() - 1);
    }
}