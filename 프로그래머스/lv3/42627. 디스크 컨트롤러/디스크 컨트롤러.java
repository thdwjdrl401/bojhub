import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                int result = Integer.compare(a[1], b[1]);
                return result;
            }
        });
        PriorityQueue<int[]> pq2 = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                int result = Integer.compare(a[0], b[0]);
                if(result == 0) {
                    int result2 = Integer.compare(a[1], b[1]);
                    if(result2 == 0) return Integer.compare(a[2], b[2]);
                    return result2;
                }
                return result;
            }
        });
        // 우선순위 : 0: 소요시간, 1: 요청시각, 2: 작업번호
        for(int i = 0; i < jobs.length; i++){
            int[] cur = jobs[i];
            pq.offer(new int[]{cur[1], cur[0], i});
        }
        int time = 0;
        int result = 0;
        while(true){
            while(true){
                if(pq.isEmpty()) break;
                int[] cur = pq.peek();
                if(cur[1] > time) break;
                pq2.offer(pq.poll());
            }
            if(!pq2.isEmpty()){
                int[] cur = pq2.poll();
                time += cur[0]; 
                result += time - jobs[cur[2]][0];
            } else{
                time++;
            }
            if(pq.isEmpty() && pq2.isEmpty()) break;
        }

        return result / jobs.length;
    }
}