import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for(String term : terms){
            String[] subString = term.split(" ");
            map.put(subString[0], Integer.parseInt(subString[1]));
        }
        for(int i = 0; i < privacies.length; i++){
            String[] sub = privacies[i].split(" ");
            String date = sub[0];
            String term = sub[1];
            String[] dateSplit = date.split("\\.");

            dateSplit[0] = String.valueOf(Integer.parseInt(dateSplit[0]) + (Integer.parseInt(dateSplit[1]) + map.get(term) - 1) / 12);
            dateSplit[1] = String.valueOf((Integer.parseInt(dateSplit[1]) + map.get(term) - 1) % 12 + 1);
            if(dateSplit[1].length() == 1) dateSplit[1] = "0" + dateSplit[1];
            String dueDate = dateSplit[0] + "." + dateSplit[1] + "." + dateSplit[2];
            if(today.compareTo(dueDate) >= 0) list.add(i + 1);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}