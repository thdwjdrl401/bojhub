class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int[] score = new int[3];
        int index = 0;
        int scoreIndex = 0;
        for(int i = 0; i < dartResult.length(); i++){
            char c = dartResult.charAt(i);
            if(c == 'S' || c == 'D' || c == 'T'){
                score[scoreIndex] = Integer.parseInt(dartResult.substring(index, i));
                if(c == 'D') score[scoreIndex] = score[scoreIndex] * score[scoreIndex];
                if(c == 'T') score[scoreIndex] = score[scoreIndex] * score[scoreIndex] * score[scoreIndex];
                if(dartResult.length() > i + 1 && (dartResult.charAt(i + 1) == '*' || dartResult.charAt(i + 1) == '#')){
                    if(dartResult.charAt(i + 1) == '*'){
                        score[scoreIndex] *= 2;
                        if(scoreIndex != 0) score[scoreIndex - 1] *= 2;
                    } else score[scoreIndex] *= -1;
                    index = i + 2;
                }
                else index = i + 1;
                scoreIndex++;
            }
        }
        for(int i : score) answer += i;
        return answer;
    }
}