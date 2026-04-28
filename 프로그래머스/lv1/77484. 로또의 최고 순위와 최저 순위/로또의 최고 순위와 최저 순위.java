import java.util.*;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        Arrays.sort(lottos);
        Arrays.sort(win_nums);
        int max = 0, min = 0;
        int lottoIndex = 0;
        for(int i = 0; i < win_nums.length; i++){
            
            while(lottoIndex < 6 && lottos[lottoIndex] <= win_nums[i]){
                if(lottos[lottoIndex] == 0){
                    max++;
                } else if(lottos[lottoIndex] == win_nums[i]){
                    max++;
                    min++;
                }
                lottoIndex++;
            }
            System.out.print(lottos[i] + " ");
        }
        System.out.println();
        System.out.println(max + ":" + min);
        int[] rank = new int[]{6, 6, 5, 4, 3, 2, 1};
        return new int[]{rank[max], rank[min]};
    }
}