class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int yCount = 0;
        int pCount = 0;
        for(int i = 0; i < s.length(); i++){
            char curChar = s.charAt(i);
            if(curChar == 'y' || curChar == 'Y') yCount++;
            if(curChar == 'p' || curChar == 'P') pCount++;
        }
        if(yCount != pCount) return false;

        return answer;
    }
}