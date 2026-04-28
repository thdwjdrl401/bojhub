class Solution {
    public int solution(int n) {
        if (n < 4) return 0; // 1,2,3에는 합성수가 없음

        boolean[] isComposite = new boolean[n + 1]; // true면 합성수
        for (int p = 2; p * p <= n; p++) {
            if (!isComposite[p]) {                // p가 소수라면
                for (int j = p * p; j <= n; j += p) {
                    isComposite[j] = true;        // 배수는 합성수
                }
            }
        }

        int count = 0;
        for (int i = 4; i <= n; i++) {            // 4부터가 첫 합성수
            if (isComposite[i]) count++;
        }
        return count;
    }
}
