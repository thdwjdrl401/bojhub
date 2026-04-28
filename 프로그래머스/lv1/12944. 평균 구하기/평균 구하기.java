class Solution {
    public double solution(int[] arr) {
        double sum = 0;
        for(int i : arr) sum += i;
        
        double answer = sum / arr.length;
        return answer;
    }
}