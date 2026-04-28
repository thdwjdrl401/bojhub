import java.util.*;
class Solution {
    public String solution(String X, String Y) {
        Map<String, Integer> map = new HashMap<>();
        for(int i = 1; i <= X.length(); i++){
            String cur = X.substring(i - 1, i);
            if(map.get(cur) != null) map.put(cur, map.get(cur) + 1);
            else map.put(cur, 1);
        }
        List<String> stringList = new ArrayList<>();
        for(int i = 1; i <= Y.length(); i++){
            String cur = Y.substring(i - 1, i);
            if(map.get(cur) != null && map.get(cur) != 0){
                map.put(cur, map.get(cur) - 1);
                stringList.add(cur);
            }
        }
        if(stringList.size() == 0) return "-1";
        stringList.sort(Comparator.reverseOrder());
        if(stringList.get(0).equals("0")) return "0";
        StringBuilder sb = new StringBuilder();
        for(String s : stringList){
            sb.append(s);
        }
        return sb.toString();
    }
}