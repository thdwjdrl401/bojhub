class Solution {
    public int solution(int[] money) {
        int answer = 0;
        int n = money.length;
        int a = rob(money, 0, n-2);
        int b = rob(money, 1, n-1);
        
        return Math.max(a, b);
    }
    private int rob (int[] money, int start, int end){
        int prev2 = 0;
        int prev1 = 0;
        for(int i = start; i <= end; i++){
            int cur = Math.max(prev1, prev2 + money[i]);
            prev2 = prev1;
            prev1 = cur;
        }
        return prev1;
    }
}