import java.util.*;
class Solution {
    public int solution(String[] babbling) {
        List<String> list = new ArrayList<>();
        String[] words = {"aya", "ye", "woo", "ma"};
        String[] repeatwords = {"ayaaya", "yeye", "woowoo", "mama"};
        int answer = 0;
        for(int i = 0; i < babbling.length; i++){
            String cur = babbling[i];
            for(String word : words){
                cur = cur.replace(word, " ");
            }
            if(cur.trim().equals("")){
                boolean isRepeat = false;
                for(String word : repeatwords){
                    if(babbling[i].contains(word)) isRepeat = true;
                }
                if(!isRepeat) answer++;
            }
        }
        
        return answer;
    }
}