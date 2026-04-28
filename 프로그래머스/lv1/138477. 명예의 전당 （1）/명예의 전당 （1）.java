import java.util.*;
class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        int min = score[0];
        List<Integer> honorList = new ArrayList<>();
        answer[0] = score[0];
        honorList.add(score[0]);
        for(int i = 1; i < score.length; i++){
            int curScore = score[i];
            if(honorList.size() < k){
                honorList.add(curScore);
                honorList.sort(Comparator.reverseOrder());
                answer[i] = honorList.get(honorList.size() - 1);
            } else if(honorList.get(honorList.size() - 1) < curScore){
                honorList.add(curScore);
                honorList.sort(Comparator.reverseOrder());
                honorList.remove(honorList.size() - 1);
                answer[i] = honorList.get(honorList.size() - 1);
            } else{
                answer[i] = honorList.get(honorList.size() - 1);
            }
        }
        return answer;
    }
}