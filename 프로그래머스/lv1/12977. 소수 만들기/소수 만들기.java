class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        for(int x = 0; x < nums.length - 2; x++){
            for(int y = x + 1; y < nums.length - 1; y++){
                for(int z = y + 1; z < nums.length; z++){
                    if(isPrime(nums[x] + nums[y] + nums[z])) answer++;
                }
            }
        }

        return answer;
    }
    private boolean isPrime(int number){
        for(int i = 2; i < number; i++){
            if(number % i == 0) return false;
        }
        return true;
    }
}