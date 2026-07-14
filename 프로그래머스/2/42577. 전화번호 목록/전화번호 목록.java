import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        HashSet<String> set = new HashSet<>();
        Arrays.sort(phone_book);
        for(int i = 0; i < phone_book.length; i++){
            String cur = phone_book[i];
            StringBuilder sb = new StringBuilder();
            
            for(int j = 0; j < cur.length(); j++){
                sb.append(cur.charAt(j));
                if(set.contains(sb.toString())) return false;
                
            }
            set.add(cur);
        }
        return true;
    }
}