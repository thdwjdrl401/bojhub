class Solution {
    public int solution(String name) {
        int n = name.length();
        int result = 0;
        for(int i = 0; i < name.length(); i++){
            if(name.charAt(i) - 'A' > 13) result +=  'Z' - name.charAt(i) + 1;
            else result += name.charAt(i) - 'A';
        }
        int move = n - 1; // 일단 오른쪽으로만 간 경우
        for (int i = 0; i < n; i++) {
            int j = i + 1;
            // 연속 A 구간의 끝 찾기
            while (j < n && name.charAt(j) == 'A') j++;

            // 두 가지 우회 패턴 고려
            int leftThenRight  = 2 * i + (n - j);
            int rightThenLeft  = i + 2 * (n - j);
            move = Math.min(move, Math.min(leftThenRight, rightThenLeft));
        }
        return result + move;
    }
}
// ABCDEFGHIJKLMNOPQRSTUVWXYZ