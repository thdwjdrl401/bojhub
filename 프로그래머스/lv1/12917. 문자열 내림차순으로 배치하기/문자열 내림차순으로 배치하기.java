import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String solution(String s) {
        Character[] cArray = new Character[s.length()];
        for(int i = 0; i < s.length(); i++){
            cArray[i] = s.charAt(i);
        }
        Arrays.sort(cArray, (a, b) -> {
            return Character.compare(b, a);
        });
        StringBuilder sb = new StringBuilder(cArray.length);
        for(char c : cArray){
            sb.append(c);
        }
        
        return sb.toString();
    }
}