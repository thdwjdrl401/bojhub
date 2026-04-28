import java.util.*;

class Solution {
    
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        for(String[] s : clothes){
            String type = s[1];
            if(!map.containsKey(type)){
                map.put(type, 1);
            } else{
                map.put(type, map.get(type) + 1);
            }
        }
        int result = 1;
        for(Map.Entry<String, Integer> m : map.entrySet()){
            result *= m.getValue() + 1;
        }
        return result -1;
    }
}