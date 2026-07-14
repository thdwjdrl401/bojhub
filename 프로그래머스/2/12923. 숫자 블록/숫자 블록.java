import java.util.*;
class Solution {
    public int[] solution(long begin, long end) {
        int gap = (int)(end - begin) + 1;
        int[] answer = new int[gap];
        int k = 1;
        for(long i = end; i >= begin; i--){
            int block = 1;
            for(long j = 2; j * j <= i; j++){
                if(i % j == 0){
                    long result = i / j;
                    if(result <= 10_000_000){
                        block = (int)result;
                        break;
                    } else{
                        block = (int)j;
                        continue;
                    }
                }
            }
            answer[gap - k++] = block;
        }
        if(begin == 1) answer[0] = 0;
        return answer;
    }
}