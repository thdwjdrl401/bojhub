class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for(int i = 0; i < n; i++){
            int cur1 = arr1[i];
            int cur2 = arr2[i];
            StringBuilder sb = new StringBuilder(n);
            for(int j = n - 1; j >= 0; j--){
                boolean check = false;
                if(cur1 >= Math.pow(2, j)){
                    check = true;
                    cur1 -= Math.pow(2,j);
                }
                if(cur2 >= Math.pow(2, j)){
                    check = true;
                    cur2 -= Math.pow(2,j);
                } 
                if(check) sb.append("#");   
                else sb.append(" ");   
                
            }
            answer[i] = sb.toString();
        }
        return answer;
    }
}