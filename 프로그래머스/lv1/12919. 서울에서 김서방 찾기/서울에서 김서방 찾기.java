class Solution {
    public String solution(String[] seoul) {
        int x = 0;
        String answer = "김서방은 0에 있다";
        
        for(int i = 0; i < seoul.length; i++){
            if(seoul[i].equals("Kim")) x = i;
        }
        answer = answer.replace("0", Integer.toString(x));
        
        return answer;
    }
}