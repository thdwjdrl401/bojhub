import java.util.*;
class Solution {
    public int solution(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        int answer = 0;
        for(int n : numbers) set.add(n);
        for(int i = 1; i <= 9; i++){
            if(!set.contains(i))answer += i;
        }
        return answer;
    }
}