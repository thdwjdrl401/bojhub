class Solution {
    public String solution(String s, String skip, int index) {
        boolean[] isSkip = new boolean[26];
        for(char c : skip.toCharArray()){
            isSkip[c - 'a'] = true;
        }
        StringBuilder sb = new StringBuilder();

        for(char c : s.toCharArray()){
            char cur = c;
            int moved = 0;
            while(moved < index){
                cur++;
                if(cur > 'z') cur = 'a';
                if(isSkip[cur - 'a']){
                    continue;
                }
                moved++;
            }
            sb.append(cur);
        }
        
        return sb.toString();
    }
}