class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int firstIndex = 0;
        int secondIndex = 0;
        for(int i = 0; i < goal.length; i++){
            String goalWord = goal[i];
            if(firstIndex < cards1.length && cards1[firstIndex].equals(goalWord)){
                firstIndex++;
            } else if(secondIndex < cards2.length && cards2[secondIndex].equals(goalWord)){
                secondIndex++;
            } else{
                return "No";
            }
        }
        return "Yes";
    }
}