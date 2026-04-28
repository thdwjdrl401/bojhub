import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        Deque<Object[]> dq = new ArrayDeque<>();
        boolean[] visited = new boolean[words.length];
        dq.offer(new Object[]{begin, 0});
        while(!dq.isEmpty()){
            Object[] current = dq.poll();
            String currentWord = (String) current[0];
            int currentCount = (int) current[1];
            for(int i = 0; i < words.length; i++){
                if(visited[i]) continue;
                String nextWord = words[i];
                if(!canMove(currentWord, nextWord)) continue;
                if(nextWord.equals(target)) return currentCount + 1;
                visited[i] = true;
                dq.offer(new Object[]{nextWord, currentCount + 1});
            }
        }
        return answer;
    }
    private boolean canMove(String a, String b){
        int diff = 0;
        for(int i = 0; i < a.length(); i++){
            if(a.charAt(i) != b.charAt(i)) diff++;
            if(diff > 1) return false;
        }
        return true;
    }
}