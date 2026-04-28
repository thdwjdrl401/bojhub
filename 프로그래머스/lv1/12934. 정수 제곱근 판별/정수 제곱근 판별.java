import java.util.*;
class Solution {
    public long solution(long n) {
        double square = Math.sqrt((double)n);
        if(square % 1 == 0) return (long) Math.pow(square + 1, 2);
        return -1;
    }
}