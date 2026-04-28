import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        Deque<Integer> dq = new ArrayDeque<>();
        dq.offer(arr[0]);
        for(int i : arr){
            if(dq.peekLast() != i) dq.offer(i);
        }
        int[] answer = new int[dq.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = dq.poll();
        }
        return answer;
    }
}
