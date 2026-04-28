import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] correctCount = new int[]{0, 0, 0};
        int[] pattern2 = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        int[] pattern3 = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        for(int i = 0; i < answers.length; i++){
            if(answers[i] == i % 5 + 1) correctCount[0]++;
            if(answers[i] == pattern2[i % 8]) correctCount[1]++;
            if(answers[i] == pattern3[i % 10]) correctCount[2]++;
        }
        
        int max = 0;
        int maxIndex;
        for(int i = 0; i < 3; i++){
            if(max < correctCount[i]){
                max = correctCount[i];
                maxIndex = i;
            }
            // System.out.println(correctCount[i]);
        }
        
        List<Integer> resultList = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            if(max == correctCount[i]){
                resultList.add(i+1);
            }
        }
        
        return resultList.stream().mapToInt(Integer::intValue).toArray();
    }
}