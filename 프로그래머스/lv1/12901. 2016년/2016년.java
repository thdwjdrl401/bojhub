class Solution {
    public String solution(int a, int b) {
        int[] month = new int[]{31 ,29, 31 ,30 ,31 ,30 ,31 ,31 ,30 ,31 ,30 ,31};
        String[] day = new String[]{"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};
        int days = b;
        for(int i = 0; i < a - 1; i++){
            days += month[i];
        }
        
        
        String answer = day[days % 7];
        return answer;
    }
}