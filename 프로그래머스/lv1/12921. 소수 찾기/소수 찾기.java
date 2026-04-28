class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int i = 2; i <= n; i++){
            if(isPrime(i)) answer++;
        }
        return answer;
    }
    
    private boolean isPrime(int n){
        if(n < 2) return false;
        if(n == 2 || n == 3) return true;
        if(n % 2 == 0 || n % 3 == 0) return false;
        for(int i = 5; i <= n / i; i += 6){
            if(n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }
}