import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] A;
	
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
        st = new StringTokenizer(br.readLine());
    	int plus = Integer.parseInt(st.nextToken());
    	int minus = Integer.parseInt(st.nextToken());
    	int mul = Integer.parseInt(st.nextToken());
    	int div = Integer.parseInt(st.nextToken());
        dfs(1, A[0], plus, minus, mul, div);
        System.out.println(max);
        System.out.println(min);
    }
    
    static void dfs(int depth, int result, int plus, int minus, int mul, int div) {
    	if(depth == N) {
    		max = Math.max(max, result);
    		min = Math.min(min, result);
    		return;
    	}
    	int cur = A[depth];
    	if(plus > 0) dfs(depth + 1, result + cur, plus - 1, minus, mul, div);
    	if(minus > 0) dfs(depth + 1, result - cur, plus, minus - 1, mul, div);
    	if(mul > 0) dfs(depth + 1, result * cur, plus, minus, mul - 1, div);
    	if(div > 0) dfs(depth + 1, result / cur, plus, minus, mul, div - 1);
    }
}


