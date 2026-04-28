import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < completion.length; i++){
            String cur = completion[i];
            if(map.containsKey(cur)) map.put(cur, map.get(cur) + 1);
            else map.put(cur, 1);
        }
        for(int i = 0; i < participant.length; i++){
            String cur = participant[i];
            if(map.containsKey(cur)){
                int count = map.get(cur);
                if(count == 0) return cur;
                else map.put(cur, count - 1);
            } else return cur;
        }
        return "";
    }
}