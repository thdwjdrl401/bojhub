class Solution {
    int answer = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, 0, target);
        return answer;
    }
    private void dfs(int[] numbers, int index, int result, int target){
        if(index == numbers.length){
            if(result == target) answer++;
            return;
        }
        dfs(numbers, index + 1, result + numbers[index], target);
        dfs(numbers, index + 1, result - numbers[index], target);
    }
}