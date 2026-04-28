class Solution {
    public int solution(int n, long l, long r) {
        int count = 0;
        for(long i = l - 1; i < r; i++){
            if(isOne(n, i)) count++;
        }
        return count;
    }
    private boolean isOne(int n, long i){
        for(int j = 0; j < n; j++){
            if(i % 5 == 2) return false;
            if(i == 0) break;
            i /= 5;
        }
        return true;
    }
}
