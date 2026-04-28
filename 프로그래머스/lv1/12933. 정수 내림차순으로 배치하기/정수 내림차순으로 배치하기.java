import java.util.*;
class Solution {
    public long solution(long n) {
        List<Integer> list = new ArrayList<>();
        while(n > 0){
            list.add((int)(n % 10));
            n /= 10;
        }
        list.sort(Comparator.reverseOrder());
        long answer = 0;
        for(int i : list){
            answer = answer * 10 + i;
        }
        return answer;
    }
}