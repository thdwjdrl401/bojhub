import java.io.*;
import java.util.*;

public class Main {

	static int N, P;
	static int[][] map;
	static int[] dp;
	static final int INF = 100_000_000;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
       	String YN = br.readLine();
       	P = Integer.parseInt(br.readLine());
       	
        int startBit = 0;
        int count = 0;

        for (int i = 0; i < N; i++) {
            if (YN.charAt(i) == 'Y') {
                startBit |= (1 << i);
                count++;
            }
        }

        if (P == 0) {
            System.out.println(0);
            return;
        }

        if (count == 0) {
            System.out.println(-1);
            return;
        }

        if (count >= P) {
            System.out.println(0);
            return;
        }

        dp = new int[1 << N];
        Arrays.fill(dp, -1);

        int answer = dp(startBit);
        System.out.println(answer >= INF ? -1 : answer);

	}
    
    static int dp(int mask) {
    	if(Integer.bitCount(mask) >= P) {
    		return 0;
    	}
    	
    	if(dp[mask] != -1) return dp[mask];
    	
        int result = INF;
    	for (int i = 0; i < N; i++) {
            if ((mask & (1 << i)) != 0) continue;
			int min = INF;
			
			for (int j = 0; j < N; j++) {
			    if ((mask & (1 << j)) == 0) continue;
			    min = Math.min(min, map[j][i]);
			}
            result = Math.min(result, min + dp(mask| (1 << i)));
		}
    	
    	return dp[mask] = result;
    }
}