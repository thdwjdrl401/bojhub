import java.util.*;
class Solution {
    public int solution(String s) {
        Map<String, String> map = new HashMap<>(Map.ofEntries(
            Map.entry("zero", "0"),
            Map.entry("one", "1"),
            Map.entry("two", "2"),
            Map.entry("three", "3"),
            Map.entry("four", "4"),
            Map.entry("five", "5"),
            Map.entry("six", "6"),
            Map.entry("seven", "7"),
            Map.entry("eight", "8"),
            Map.entry("nine", "9"),
            Map.entry("0", "0"),
            Map.entry("1", "1"),
            Map.entry("2", "2"),
            Map.entry("3", "3"),
            Map.entry("4", "4"),
            Map.entry("5", "5"),
            Map.entry("6", "6"),
            Map.entry("7", "7"),
            Map.entry("8", "8"),
            Map.entry("9", "9")
        ));
        String result = "";
        for(int i = 0; i < s.length(); i++){
            String cur = String.valueOf(s.charAt(i));
            while(map.get(cur) == null){
                i++;
                cur += String.valueOf(s.charAt(i));
            }
            result += map.get(cur); 
        }
        System.out.println(result);
        return Integer.parseInt(result);
    }
}