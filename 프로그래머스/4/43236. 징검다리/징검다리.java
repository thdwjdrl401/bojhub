import java.util.*;
class Solution {
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        int left = 0, right = distance + 1, mid = 0;
        while(left < right){
            mid = (left + right) / 2;
            int removeCount = 0;
            int prev = 0;
            for(int rock : rocks){
                if(rock - prev < mid) removeCount++;
                else prev = rock;
            }
            if(distance - prev < mid) removeCount++;
            if(removeCount > n){
                right = mid;
            } else{
                left = mid + 1;
            }
        }
        
        return right - 1;
    }
}