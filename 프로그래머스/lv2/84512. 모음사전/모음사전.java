import java.util.*;

class Solution {
    public int solution(String word) {
        int[] w = {781, 156, 31, 6, 1}; // 자리별 가중치
        String order = "AEIOU";
        int ans = 0;

        for (int i = 0; i < word.length(); i++) {
            int idx = order.indexOf(word.charAt(i)); // A=0,E=1,I=2,O=3,U=4
            ans += idx * w[i]; // 그 자리에서 점프하는 양
            ans += 1;          // 그 자리에서 '바로 끝나는' 단어 한 개 카운트
        }
        return ans;
    }
}
