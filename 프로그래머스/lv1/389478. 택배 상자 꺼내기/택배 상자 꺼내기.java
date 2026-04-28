class Solution {
    public int solution(int n, int w, int num) {
        int count = 0;
        int number = num;
        while(number <= n){
            count++;
            int rem = number % w;
            if(rem == 0) rem = w;
            number = number + 2 * (w - rem) + 1;
        }
        return count;
    }
}