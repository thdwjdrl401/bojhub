import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] cnt = new int[n];
        Arrays.fill(cnt, 1);
        
        for(int i : lost) cnt[i - 1]--;
        for(int i : reserve) cnt[i - 1]++;
        for(int i = 0; i < n; i++){
            if(cnt[i] == 0){
                if(i > 0 && cnt[i - 1] == 2){
                    cnt[i]++;
                    cnt[i - 1]--;
                }else if(i < n-1 && cnt[i + 1] == 2){
                    cnt[i]++;
                    cnt[i + 1]--;
                }
            }
        }
        int answer = 0;
        for(int i : cnt){
            if(i > 0) answer++;
            System.out.println(i);
        }
        return answer;
    }
}