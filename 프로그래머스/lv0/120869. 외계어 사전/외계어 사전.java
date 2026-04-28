import java.util.*;

class Solution {
    public int solution(String[] spell, String[] dic) {
        // spell을 정렬된 키로 변환
        char[] s = new char[spell.length];
        for (int i = 0; i < spell.length; i++) s[i] = spell[i].charAt(0);
        Arrays.sort(s);
        String key = new String(s);

        // dic의 각 단어를 정렬해 key와 동일한지 검사
        for (String w : dic) {
            if (w.length() != spell.length) continue; // 길이 다르면 불가능
            char[] a = w.toCharArray();
            Arrays.sort(a);
            if (key.equals(new String(a))) return 1;  // 정확히 같은 멀티셋
        }
        return 2;
    }
}
