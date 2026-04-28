import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static long[] arr;
    static long[] lis;
    static int[] idx;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new long[N];
        lis = new long[N];
        idx = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        int len = 0; // 현재 LIS 길이

        for (int i = 0; i < N; i++) {
            int pos = lowerBound(lis, 0, len, arr[i]);
            lis[pos] = arr[i];
            idx[i] = pos;

            if (pos == len) {
                len++;
            }
        }

        long[] answer = new long[len];
        int target = len - 1;

        for (int i = N - 1; i >= 0; i--) {
            if (idx[i] == target) {
                answer[target] = arr[i];
                target--;
            }
            if (target < 0) break;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(len).append('\n');
//        for (int i = 0; i < len; i++) {
//            sb.append(answer[i]).append(' ');
//        }

        System.out.println(sb);
    }

    static int lowerBound(long[] arr, int left, int right, long target) {
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}