import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int i;
        HashSet<String> check = new HashSet<>();
        boolean isPass = false;
        check.add(words[0]);
        for(i = 1; i < words.length; i++){
            
            if(i > 1 && check.contains(words[i])) break;
            if(words[i-1].charAt(words[i-1].length() - 1) != words[i].charAt(0)) break;
            check.add(words[i]);
            if(i == words.length - 1) isPass = true;
        }
        int[] answer;

        if(isPass){
            answer = new int[]{0, 0};
        }else{
            answer = new int[]{(i%n) + 1, (i/n) + 1};
        }

        return answer;
    }
}