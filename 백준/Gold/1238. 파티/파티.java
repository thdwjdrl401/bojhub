import java.io.*;
import java.util.*;
public class Main{
	
	static int N, M, X;
	static List<int[]>[] graph;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		graph = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int T = Integer.parseInt(st.nextToken());
			graph[A].add(new int[] {B, T});
		}
		int max = 0;
		for (int i = 1; i <= N; i++) {
			int x = dijkstra(i, X) + dijkstra(X, i);
			max = Math.max(max, x);
		}
		System.out.println(max);
		
	}
	
	static int dijkstra(int start, int end) {
		int[] dist = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				return Integer.compare(a[1], b[1]);
			}
		});
		pq.offer(new int[] {start, dist[start]});
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			if(cur[0] == end) return cur[1];
			for(int[] next : graph[cur[0]]) {
				int nextDist = cur[1] + next[1];
				if(nextDist < dist[next[0]]) {
					dist[next[0]] = nextDist;
					pq.offer(new int[] {next[0], nextDist});
				}
			}
		}
		return 0;
	}
}