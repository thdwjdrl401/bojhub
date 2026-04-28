class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        for(int i = 1; i <= number; i++){
            int count = divisionCount(i);
            if(count > limit) answer += power;
            else answer += count;
        }
        return answer;
    }
    private int divisionCount(int number){
        int result = 0;
        for(int i = 1; i <= number / i; i++){
            if(number % i == 0){
                if(i == number / i) result++;   
                else result += 2;
            }
        }
        return result;
    }
}