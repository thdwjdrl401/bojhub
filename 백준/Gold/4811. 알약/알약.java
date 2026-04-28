import java.io.*;
import java.util.*;


public class Main {
	
	static long count = 0;
	static long[][] dp;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true) {
        	int cur = Integer.parseInt(br.readLine());
        	if(cur == 0) break;
        	
        	dp = new long[31][31];
        	for (int i = 0; i < 31; i++) {
				Arrays.fill(dp[i], -1);
			}
        	
        	sb.append(func(cur, 0)).append('\n');
        	
        }
        System.out.println(sb);
    }
    
    static long func(int w, int h) {
    	if(w == 0 && h == 0) {
    		return 1;
    	}
    	if(dp[w][h] != -1) {
    		return dp[w][h];
    	}
    	dp[w][h] = 0;
    	
    	if(w > 0) {
    		dp[w][h] += func(w - 1, h + 1);
    	}
    	if(h > 0) {
    		dp[w][h] += func(w, h - 1);
    	}
    	count++;
    	return dp[w][h];
    }
}













