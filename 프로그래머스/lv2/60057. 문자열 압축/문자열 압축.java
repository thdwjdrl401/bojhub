class Solution {
    public int solution(String s) {
        int answer = s.length();
        for(int subLength = 1; subLength <= s.length() / 2; subLength++){
            StringBuilder sb = new StringBuilder();
            for(int x = 0; x < s.length(); x += subLength){
                if(x + subLength > s.length()){
                    sb.append(s.substring(x, s.length()));
                    break;
                }
                String sub = s.substring(x, x + subLength);
                int count = 1;
                int nextIndex = x + count * subLength;
                int nextnextIndex = x + (count + 1) * subLength;
                while(nextnextIndex <= s.length() && sub.equals(s.substring(nextIndex, nextnextIndex))){
                    count++;
                    nextIndex += subLength;
                    nextnextIndex += subLength;
                }
                if(count > 1){
                    x += subLength * (count - 1);
                    sb.append(count);
                }
                sb.append(sub);
            }
            answer = Math.min(answer, sb.length());
        }
        return answer;
    }
}