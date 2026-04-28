import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int K;
	static int[] dp = new int[100001];
	static int[] count = new int[100001];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		if (N == K) {
		    System.out.println(0);
		    System.out.println(1);
		    return;
		}
		Arrays.fill(dp, -1);
		bfs();
		System.out.println(dp[K]);
		System.out.println(count[K]);
	}
	
	static void bfs() {
	    Deque<Integer> dq = new ArrayDeque<>();
	    dq.offer(N);
	    dp[N] = 0;
	    count[N] = 1;

	    while (!dq.isEmpty()) {
	        int cur = dq.poll();
	        int[] nexts = {cur - 1, cur + 1, cur * 2};
	        int time = dp[cur];

	        for (int i = 0; i < 3; i++) {
	            int next = nexts[i];
	            if (next < 0 || next > 100000) continue;
	            
	            if (dp[next] == -1) {
	            	dp[next] = dp[cur] + 1;
	            	count[next] = count[cur];
                    dq.offer(next);
                } else if (dp[next] == dp[cur] + 1) {
                	count[next] += count[cur];
                }
	        }
	    }
	}

}
