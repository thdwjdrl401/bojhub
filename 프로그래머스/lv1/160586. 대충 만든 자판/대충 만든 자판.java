import java.util.*;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        int[][] keyIndex = new int[keymap.length][26];
        for(int i = 0; i < keymap.length; i++){
            Arrays.fill(keyIndex[i], -1);
            String key = keymap[i];
            for(int j = 0; j < key.length(); j++){
                char ch = key.charAt(j);
                if(keyIndex[i][ch - 'A'] == -1) keyIndex[i][ch - 'A'] = j + 1;
            }
        }
        for(int i = 0; i < targets.length; i++){
            String target = targets[i];
            for(int j = 0; j < target.length(); j++){
                char ch = target.charAt(j);
                int min = Integer.MAX_VALUE;
                for(int x = 0; x < keymap.length; x++){
                    int cur = keyIndex[x][ch - 'A'];
                    if(cur != -1) min = Math.min(min, cur);
                }
                if(min == Integer.MAX_VALUE){
                    answer[i] = -1;
                    break;
                }
                else answer[i] += min;
            }
        }
        return answer;
    }
}