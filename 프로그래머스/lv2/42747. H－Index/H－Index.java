class Solution {
    public int solution(int[] citations) {
        int n = citations.length;
        int h = 0;
        int hn;
        
        for(int i = 1; i <= n; i++){
            int count = 0;
            for(int j = 0; j < n; j++){
                if(citations[j] >= i) count++;
            }
            if(count < i) break;
            h = i;
        }
        
        return h;
    }
}