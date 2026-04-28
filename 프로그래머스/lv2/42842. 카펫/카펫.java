import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        int sum = brown + yellow;
        
        int x = 0;
        while(x < (brown - 2) / 2 ){
            x++;
            if(sum % x == 0){
                int y = sum / x;
                if((x + y) * 2 - 4 == brown){
                    int max = Math.max(x, y);
                    int min = Math.min(x, y);
                    return new int[]{max, min};
                }
            }
        }
        int[] answer = {};
        return answer;
    }
}