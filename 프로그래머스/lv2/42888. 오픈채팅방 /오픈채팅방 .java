import java.util.*;

class Solution {
    public String[] solution(String[] recordArray) {
        HashMap<String, String> nameSet = new HashMap<>();
        for(String record : recordArray){
            String[] splitRecord = record.split(" ");
            if(!splitRecord[0].equals("Leave")){
                nameSet.put(splitRecord[1], splitRecord[2]);
            }
        }
        List<String> answerList = new ArrayList<>();
        for(String record : recordArray){
            String[] splitRecord = record.split(" ");
            if(splitRecord[0].equals("Enter")){
                answerList.add( nameSet.get(splitRecord[1]) + "님이 들어왔습니다.");
            }
            if(splitRecord[0].equals("Leave")){
                answerList.add( nameSet.get(splitRecord[1]) + "님이 나갔습니다.");
            }
        }
        
        String[] answer = new String[answerList.size()];
        int i = 0;
        for(String answerString : answerList){
            answer[i] = answerString;
            i++;
        }
        
        return answer;
    }
}