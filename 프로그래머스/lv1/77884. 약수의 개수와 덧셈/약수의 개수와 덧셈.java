class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        for(int i = left; i <= right; i++){
            int count = countDivisors(i);
            if(count % 2 == 0) answer += i;
            else answer -= i;
        }
        return answer;
    }
    private int countDivisors(int n){
        int count = 0;
        for(int i = 1; i <= n / i; i++){
            if(n % i == 0){
                count++;
                if(i != n / i) count ++;
            }
        }
        return count;
    }
}