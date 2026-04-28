import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        StringBuilder sb = new StringBuilder(s);
        for(int i = 0; i < s.length(); i++){
            char shiftChar = sb.charAt(0);
            sb.deleteCharAt(0);
            sb.append(shiftChar);
            if(isCorrect(sb)) answer++;
        }
        return answer;
    }
    private boolean isCorrect(StringBuilder s){
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '(' || ch == '[' || ch == '{') stack.push(ch);
            else {
                if(stack.isEmpty()) return false;
                char cur = stack.pop();
                if(ch == ')' && cur != '(') return false;
                if(ch == ']' && cur != '[') return false;
                if(ch == '}' && cur != '{') return false;
            }
        }
        return stack.isEmpty();
    }
}