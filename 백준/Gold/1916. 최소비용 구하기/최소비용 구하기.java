import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int S, E;
	static List<int[]>[] graph;
	static int[] dist;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		graph = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			graph[A].add(new int[] {B, C});
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		dijkstra(S);
		
		System.out.println(dist[E]);
	}
	
	static void dijkstra(int start) {
		dist = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
		
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				return Integer.compare(a[1], b[1]);
			}
		});
		pq.offer(new int[] {start, 0});
		
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			if(cur[0] == E) return;
			if(cur[1] != dist[cur[0]]) continue;
			for (int[] next : graph[cur[0]]) {
				int nextWeight = cur[1] + next[1];
				if(nextWeight < dist[next[0]]) {
					pq.offer(new int [] {next[0], nextWeight});
					dist[next[0]] = nextWeight;
				}
			}
		}
	}
}
