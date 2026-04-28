class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        boolean[] paintingSection = new boolean[n];
        for(int i = 0; i < section.length; i++){
            paintingSection[section[i] - 1] = true;
        }
        for(int i = 0; i < n; i++){
            if(paintingSection[i]){
                for(int j = 0; j < m; j++){
                    if(i + j < n)paintingSection[i+j] = false;
                }
                i += m - 1;
                answer++;
            }
        }
        return answer;
    }
}