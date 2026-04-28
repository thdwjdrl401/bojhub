import java.util.*;
class Solution {
    int count = 0;
    Set set = new HashSet<>();
    public int solution(String numbers) {
        int[] numberArray = new int[numbers.length()];
        for(int i = 0; i < numbers.length(); i++){
            numberArray[i] = Integer.parseInt(numbers.substring(i, i + 1));
            System.out.println(numberArray[i]);
            
        }
        boolean[] visited = new boolean[numbers.length()];
        for(int i = 0; i < numberArray.length; i++){
            visited[i] = true;
            dfs(numberArray[i], numberArray, visited);
            visited[i] = false;
        }
        return count;
    }
    
    private void dfs(int start, int[] numberArray, boolean[] visited){
        if(!set.contains(start)){
            set.add(start);
            if(isPrime(start))count++;
        }
        for(int i = 0; i < numberArray.length; i++){
            if(visited[i]) continue;
            int newStart = start * 10 + numberArray[i];
            visited[i] = true;
            dfs(newStart, numberArray, visited);
            visited[i] = false;
        }
    }
    
    private boolean isPrime(int n){
        if(n < 2) return false;
        if(n % 2 == 0) return n == 2;
        if(n % 3 == 0) return n == 3;
        
        for(int i = 5; i <= n / i; i += 6){
            if(n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }
}