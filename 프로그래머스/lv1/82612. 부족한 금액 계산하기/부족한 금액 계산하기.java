class Solution {
    public long solution(int price, int money, int count) {
        long answer = 0;
        int realCount = 0;
        while(realCount != count){
            realCount++;
            answer += price * realCount;
        }
        answer -= money;
        if(answer < 0) return 0;
        return answer;
    }
}