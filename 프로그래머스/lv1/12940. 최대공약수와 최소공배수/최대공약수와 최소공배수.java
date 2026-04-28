class Solution {
    public int[] solution(int n, int m) {
        int gcd = gcd(n, m);
        int[] answer = {gcd, n * m / gcd};
        return answer;
    }
    private int gcd(int a, int b){
        return b == 0 ? a : gcd(b, a % b);
    }
}