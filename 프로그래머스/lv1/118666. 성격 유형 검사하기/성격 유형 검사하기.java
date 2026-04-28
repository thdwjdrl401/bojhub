import java.util.*;
class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < survey.length; i++){
            int score = choices[i];
            String cur;
            if(score > 4){
                score -= 4;
                cur = survey[i].substring(1, 2);
            } else if(score < 4){
                score  = (score - 4) * -1;
                cur = survey[i].substring(0, 1);
            } else continue;
            map.computeIfAbsent(cur, k -> 0);
            map.put(cur, map.get(cur) + score);
        }
        StringBuilder sb = new StringBuilder();
        List<String> list = List.of("RT", "CF", "JM", "AN");
        for(String s : list){
            int first = map.getOrDefault(s.substring(0, 1), 0);
            int second = map.getOrDefault(s.substring(1, 2), 0);
            if(second > first) sb.append(s.substring(1, 2));
            else sb.append(s.charAt(0));
            
        }
        return sb.toString();
    }
}