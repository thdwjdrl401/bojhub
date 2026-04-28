import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < progresses.length; i++){
            int remain = 100 - progresses[i];
            q.offer((remain + speeds[i] - 1) / speeds[i]);
        }
        
        while(!q.isEmpty()){
            int day = q.poll();
            int count = 1;
            while(!q.isEmpty() && q.peek() <= day){
                q.poll();
                count++;
            }
            list.add(count);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}