class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder(s.length());
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);
            if(cur == ' '){
                count = 0;   
            }
            else{
                if(count % 2 == 0 && cur >= 'a' && cur <= 'z'){
                    cur = (char)(cur - 32);
                }
                else if(count % 2 == 1 && cur >= 'A' && cur <= 'Z'){
                    cur = (char)(cur + 32);
                }    
                count++;
            }
            sb.append(cur);
            
        }
        return sb.toString();
    }
}