import java.util.*;
class Solution {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, (a, b) -> {
            int c = Character.compare(a.charAt(n), b.charAt(n));
            if(c != 0) return c;
            return a.compareTo(b);
        });
        return strings;
    }
}