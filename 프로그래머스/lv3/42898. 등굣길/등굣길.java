class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n][m];
        boolean[][] isPuddle = new boolean[n][m];
        for(int i = 0; i < puddles.length; i++){
            int puddlesX = puddles[i][0] - 1;
            int puddlesY = puddles[i][1] - 1;
            isPuddle[puddlesY][puddlesX] = true;
        }
        dp[0][0] = 1;
        for(int y = 0; y < n; y++){
            for(int x = 0; x < m; x++){
                if(x == 0 && y == 0) continue;
                if(isPuddle[y][x]) continue;
                dp[y][x] = ((y > 0 ? dp[y - 1][x] : 0) + (x > 0 ? dp[y][x - 1] : 0)) % 1000000007;
            }
        }
        return dp[n - 1][m - 1];
    }
}
