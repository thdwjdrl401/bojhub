import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        List<Deque<Integer>> dqList = new ArrayList<>();
        for(int i = 0; i < board[0].length; i++){
            dqList.add(new ArrayDeque<>());
            for(int j = 0; j < board.length; j++){
                if(board[j][i] != 0) dqList.get(i).add(board[j][i]);
            }
        }
        
        Deque<Integer> bucket = new ArrayDeque<>();
        int count = 0;
        for(int i = 0; i < moves.length; i++){
            if(dqList.get(moves[i] - 1).size() > 0){
                int tmp = dqList.get(moves[i] - 1).poll();
                if(bucket.size() > 0 && bucket.peekLast() == tmp){
                    bucket.pollLast();
                    count += 2;
                } else bucket.add(tmp);
            }
        }
        
        return count;
    }
}