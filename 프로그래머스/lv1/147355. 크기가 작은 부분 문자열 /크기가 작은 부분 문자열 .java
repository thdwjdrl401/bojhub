class Solution {
    public int solution(String t, String p) {
        int size = p.length();
        long pLong = Long.parseLong(p);
        int answer = 0;
        for(int i = size; i <= t.length(); i++){
            long subLong = Long.parseLong(t.substring(i - size, i));
            if(subLong <= pLong) answer++;
        }
        return answer;
    }
}