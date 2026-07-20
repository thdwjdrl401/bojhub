import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            // [0] : 작업의 소요 시간
            // [1] : 작업의 요청 시간
            // [2] : 작업의 번호
            @Override
            public int compare(int[] a, int[] b){
                if(a[0] == b[0]){
                    if(a[1] == b[1]){
                        return Integer.compare(a[2], b[2]);
                    }
                    return Integer.compare(a[1], b[1]);
                }
                return Integer.compare(a[0], b[0]);
            }
        });
        PriorityQueue<int[]> prePq = new PriorityQueue<>(new Comparator<int[]>(){
            // [0] : 작업의 소요 시간
            // [1] : 작업의 요청 시간
            // [2] : 작업의 번호
            @Override
            public int compare(int[] a, int[] b){
                if(a[1] == b[1]){
                    if(a[2] == b[2]){
                        return Integer.compare(a[0], b[0]);
                    }
                    return Integer.compare(a[2], b[2]);
                }
                return Integer.compare(a[1], b[1]);
            }
        });
        for(int i = 0; i < jobs.length; i++){
            prePq.offer(new int[]{jobs[i][1], jobs[i][0], i});
        }
        int time = 0;
        int sum = 0;
        while(!(prePq.isEmpty() && pq.isEmpty())){
            while(!prePq.isEmpty()){
                int[] cur  = prePq.poll();
                if(cur[1] > time){
                    prePq.offer(cur);
                    break;
                }
                pq.offer(cur);
            }
            if(!pq.isEmpty()){
                int[] curJob = pq.poll();
                time += curJob[0];
                sum += time - curJob[1];
            }else{
                time++;
            }
        }
        return sum / jobs.length;
    }
}