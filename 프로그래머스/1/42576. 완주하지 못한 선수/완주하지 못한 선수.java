import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < completion.length; i++){
            String cur = completion[i];
            map.put(cur, map.getOrDefault(cur, 0) + 1);
        }
        for(int i = 0; i < participant.length; i++){
            String cur = participant[i];
            Integer result = map.get(cur);
            if(result == null || result == 0) return cur;
            else map.put(cur, result - 1);
        }
        String answer = "";
        return answer;
    }
}