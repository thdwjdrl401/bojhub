import java.util.*;

class Solution {
    List<Integer> curBridge;
    int bridgeWeight;
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        curBridge = new LinkedList<>();
        bridgeWeight = 0;
        int idx = 0;
        while(idx < truck_weights.length){
            if(curBridge.size() == bridge_length){
                bridgeWeight -= curBridge.get(0);
                curBridge.remove(0);
            }
            if(weight >= bridgeWeight + truck_weights[idx]){
                curBridge.add(truck_weights[idx]);
                bridgeWeight += truck_weights[idx++];
            }else{
                curBridge.add(0);
            }
            answer++;
        }
        return answer + bridge_length;
    }
    
}