class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int yLength = arr1.length;
        int xLength = arr1[0].length;
        int[][] answer = new int[yLength][xLength];
        for(int y = 0; y < yLength; y++){
            for(int x = 0; x < xLength; x++){
                answer[y][x] = arr1[y][x] + arr2[y][x];
            }
        }
        return answer;
    }
}