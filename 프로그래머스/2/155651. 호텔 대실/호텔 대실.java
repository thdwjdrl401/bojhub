import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        boolean[][] room = new boolean[book_time.length][1450];
        for(int i = 0; i < book_time.length; i++){
            int startTime = Integer.parseInt(book_time[i][0].substring(0,2)) * 60 + Integer.parseInt(book_time[i][0].substring(3,5));
            int endTime = Integer.parseInt(book_time[i][1].substring(0,2)) * 60 + Integer.parseInt(book_time[i][1].substring(3,5)) + 10;
            // System.out.println(startTime + " " + endTime);
            Arrays.fill(room[i], startTime, endTime, true);
        }
        int result = 0;
        for(int i = 0; i < 1450; i++){
            int max = 0;
            for(int j = 0; j < book_time.length; j++){
                if(room[j][i]) max++;
            }
            result = Math.max(result, max);
        }
        return result;
    }
}