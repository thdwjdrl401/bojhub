import java.util.*;
class Solution {
    public int solution(String s) {
           int answer = 0;
        int same = 0;
        int diff = 0;
        char x = s.charAt(0);

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == x) same++;
            else diff++;

            if (same == diff) {
                answer++;
                // 남은 문자열이 있다면 새로운 기준 문자로 초기화
                if (i + 1 < s.length()) {
                    x = s.charAt(i + 1);
                }
                same = 0;
                diff = 0;
            }
        }

        // 마지막 잔여 문자열 처리
        if (same != diff) answer++;

        return answer;
    }
}