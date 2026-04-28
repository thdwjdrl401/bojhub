import java.io.*;
import java.util.*;

public class Main {

	static long N;
	static final long MOD = 1_000_000_007;
	static long[] dp;
	static Map<Long, Long> dpMap;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Long.parseLong(br.readLine());
        dpMap = new HashMap<>();
        
        long result = dp(N);
        System.out.println(result);
    }
    
    static long dp(long n) {
    	
    	if(n == 0) return 0;
    	if(n == 1) return 1;
    	if(n == 2) return 1;

    	if(dpMap.containsKey(n)) return dpMap.get(n);
    	long result = 0;
    	if(n % 2 == 1) {
        	long anplus1 = dp(n / 2 + 1) % MOD;
    		long an = dp(n / 2) % MOD;
    		
    		result = (anplus1 * anplus1 % MOD + an * an % MOD) % MOD;
    	}else {
        	long anplus1 = dp(n / 2 + 1) % MOD; 
    		long an = dp(n / 2) % MOD;
    		long anminus1 = dp(n / 2 - 1) % MOD;
    		result = (anplus1 * an % MOD + an * anminus1 % MOD) % MOD;
    	}
    	
    	dpMap.put(n, result);
    	return result;
    }
}