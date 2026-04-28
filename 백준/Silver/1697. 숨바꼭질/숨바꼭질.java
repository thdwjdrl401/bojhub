import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int K;
	static int[] dp = new int[100001];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		if (N == K) {
		    System.out.println(0);
		    return;
		}
		Arrays.fill(dp, -1);
		int result = bfs();
		System.out.println(result);
	}
	
	static int bfs() {
	    Deque<Integer> dq = new ArrayDeque<>();
	    dq.offer(N);
	    dp[N] = 0;

	    while (!dq.isEmpty()) {
	        int cur = dq.poll();
	        int[] nexts = {cur - 1, cur + 1, cur * 2};
	        int time = dp[cur];

	        for (int i = 0; i < 3; i++) {
	            int next = nexts[i];
	            if (next < 0 || next > 100000) continue;
	            if (dp[next] != -1) continue;

	            dp[next] = time + 1;
	            if (next == K) return dp[next];
	            dq.offer(next);
	        }
	    }
	    return -1;
	}

}
