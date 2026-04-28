import java.util.*;

class Solution {
    public int solution(String[] arr) {

        int nNums = (arr.length + 1) / 2;
        int[] nums = new int[nNums];
        char[] ops = new char[nNums - 1];

        for (int i = 0, ni = 0, oi = 0; i < arr.length; i++) {
            if ((i & 1) == 0) {
                nums[ni++] = Integer.parseInt(arr[i]);
            } else {
                ops[oi++] = arr[i].charAt(0);
            }
        }

        int[][] max = new int[nNums][nNums];
        int[][] min = new int[nNums][nNums];

        for (int i = 0; i < nNums; i++) {
            Arrays.fill(max[i], Integer.MIN_VALUE);
            Arrays.fill(min[i], Integer.MAX_VALUE);
            max[i][i] = min[i][i] = nums[i];
        }

        for (int len = 2; len <= nNums; len++) {
            for (int i = 0; i + len - 1 < nNums; i++) {
                int j = i + len - 1;

                for (int k = i; k < j; k++) {
                    char op = ops[k];

                    if (op == '+') {
                        max[i][j] = Math.max(max[i][j], max[i][k] + max[k + 1][j]);
                        min[i][j] = Math.min(min[i][j], min[i][k] + min[k + 1][j]);
                    } else {
                        max[i][j] = Math.max(max[i][j], max[i][k] - min[k + 1][j]);
                        min[i][j] = Math.min(min[i][j], min[i][k] - max[k + 1][j]);
                    }
                }
            }
        }
        return max[0][nNums - 1];
    }
}
