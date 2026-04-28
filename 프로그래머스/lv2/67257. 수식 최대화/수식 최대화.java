import java.util.*;
class Solution {
    public long solution(String expression) {
        long answer = 0;
        List<Long> numbers = new ArrayList<>();
        List<Character> operators = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < expression.length(); i++){
            char c = expression.charAt(i);
            if(c == '+' || c == '-' || c == '*'){
                numbers.add(Long.parseLong(sb.toString()));
                sb.setLength(0);
                operators.add(c);
            } else {
                sb.append(c);
            }
        }
        numbers.add(Long.parseLong(sb.toString()));
        char[][] orders = {
            {'+', '-', '*'},
            {'+', '*', '-'},
            {'*', '+', '-'},
            {'*', '-', '+'},
            {'-', '*', '+'},
            {'-', '+', '*'}
        };
        for(char[] order : orders){
            long result = Math.abs(evaluate(new ArrayList<>(numbers), new ArrayList<>(operators), order));
            answer = Math.max(answer, result);
        }
        return answer;
    }
    private long evaluate(List<Long> nums, List<Character> ops, char[] order){
        for(char op : order){
            for(int i = 0; i < ops.size();){
                if(ops.get(i) == op){
                    long a = nums.get(i);
                    long b = nums.get(i + 1);
                    long result = calc(a, b, op);
                    
                    nums.set(i, result);
                    nums.remove(i + 1);
                    ops.remove(i);
                } else {
                    i++;
                }
            }
        }
        return nums.get(0);
    }
    private long calc(long a, long b, char op){
        switch(op){
            case '+' : return a + b;
            case '-' : return a - b;
            case '*' : return a * b;
        }
        return 0;
    }
}