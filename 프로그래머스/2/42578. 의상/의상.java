import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < clothes.length; i++){
            String cur1 = clothes[i][0];
            String cur2 = clothes[i][1];
            map.put(cur2, map.getOrDefault(cur2, 0) + 1);
        }
        int answer = 1;
        for(Map.Entry<String, Integer> e : map.entrySet()){
            answer *= e.getValue() + 1;
        }
        return answer - 1;
    }
}