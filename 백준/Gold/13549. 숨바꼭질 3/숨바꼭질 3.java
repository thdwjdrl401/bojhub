import java.io.*;
import java.util.*;

public class Main {

	static int N, K;
	static int[] dist;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
        int MAX = Math.max(N, K) * 2 + 2; // 배열 범위 상한
		dist = new int[MAX + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		Deque<Integer> dq = new ArrayDeque<>();
        dist[N] = 0;
		dq.offer(N);
		
		while(!dq.isEmpty()) {
			int cur = dq.poll();
            int t = dist[cur];
            if(cur == K) break;

            int nx = cur * 2;
            if(nx <= MAX && dist[nx] > t) {
            	dist[nx] = t;
    			dq.addFirst(nx);
            }
            
            nx = cur - 1;
            if (nx >= 0 && dist[nx] > t + 1) {
            	dist[nx] = t + 1;
            	dq.addLast(nx);
            }
			
			nx = cur + 1;
            if (nx <= MAX && dist[nx] > t + 1) {
            	dist[nx] = t + 1;
            	dq.addLast(nx);
            }
		}
		System.out.println(dist[K]);
	}
}



