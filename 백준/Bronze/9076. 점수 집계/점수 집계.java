import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());
        for (int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] a = new int[5];
            for (int i = 0; i < 5; i++) a[i] = Integer.parseInt(st.nextToken());

            Arrays.sort(a);

            if (a[3] - a[1] >= 4) sb.append("KIN\n");
            else sb.append(a[1] + a[2] + a[3]).append('\n');
        }

        System.out.print(sb.toString());
    }
}