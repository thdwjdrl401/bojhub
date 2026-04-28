import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, Set<String>> map = new HashMap<>();
        Map<String, Integer> reportCountMap = new HashMap<>();
        for(int i = 0; i < report.length; i++){
            String[] current = report[i].split(" ");
            if(!map.containsKey(current[1])) map.put(current[1], new HashSet<>(Set.of(current[0])));
            else map.get(current[1]).add(current[0]);
        }
        for(String id : id_list){
            Set<String> currentSet = map.get(id);
            if(currentSet != null && currentSet.size() >= k){
                for(String reportId : map.get(id)){
                    if(!reportCountMap.containsKey(reportId)) reportCountMap.put(reportId, 1);
                    else reportCountMap.put(reportId, reportCountMap.get(reportId) + 1);
                }
            }
        }
        for(int i = 0; i < id_list.length; i++){
            answer[i] = reportCountMap.getOrDefault(id_list[i], 0);
        }
        return answer;
    }
}