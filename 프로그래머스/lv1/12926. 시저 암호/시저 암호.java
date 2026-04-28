class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder(s.length());
        for(int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);
            if(cur >= 'a' && cur <= 'z'){
                int x = 'a' + (cur - 'a' + n) % 26;   
                cur = (char) x;
            }
            else if(cur >= 'A' && cur <= 'Z'){
                int x = 'A' + (cur - 'A' + n) % 26;   
                cur = (char) x;
            }
            sb.append(cur);
        }
        return sb.toString();
    }
}