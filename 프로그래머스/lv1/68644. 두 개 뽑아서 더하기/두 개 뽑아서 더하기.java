import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> resultSet = new HashSet<>();
        for(int x = 0; x < numbers.length - 1; x++){
            for(int y = x + 1; y < numbers.length; y++){
                resultSet.add(numbers[x] + numbers[y]);
            }
        }
        int[] answer = resultSet
            .stream()
            .mapToInt(Integer::intValue)
            .sorted()
            .toArray();
        return answer;
    }
}