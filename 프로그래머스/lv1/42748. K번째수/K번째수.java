import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        int[] answer = new int[commands.length];
        for(int x = 0; x < commands.length; x++){
            int i = commands[x][0];
            int j = commands[x][1];
            int k = commands[x][2];
            int[] splitArray = Arrays.copyOfRange(array, i-1, j);
            Arrays.sort(splitArray);

            answer[x] = splitArray[k-1];
        }
        return answer;
    }
}