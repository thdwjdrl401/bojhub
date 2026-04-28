class Solution {
    public long solution(int k, int d) {
        
        
        long answer = 0;
        
        for(long a = 0; a <= d; a = a + k){
            long bk = (long) Math.sqrt(Math.pow(d, 2) - Math.pow(a, 2));            
            answer += bk / k + 1;
        }
        
        return answer;
    }
}