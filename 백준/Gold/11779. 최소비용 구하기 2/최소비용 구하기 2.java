import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int startNode, endNode;
	static List<int[]>[] graph;
	static int[] dist;
	static int[] p;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		graph = new ArrayList[N+1];
		p = new int[N + 1];
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
		startNode = Integer.parseInt(st.nextToken());
		endNode = Integer.parseInt(st.nextToken());
		
		dijkstra(startNode);
		System.out.println(dist[endNode]);
		
		StringBuilder sb = new StringBuilder();
		sb.append(endNode).append(" ");
		int cur = endNode;
		int count = 1;
		while(true) {
			int parrent = p[cur];
			sb.insert(0, parrent + " ");
			cur = parrent;
			count++;
			if(parrent == startNode) break;
		}
		System.out.println(count);
		System.out.println(sb);
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
			int cur[] = pq.poll();
			if(dist[cur[0]] != cur[1]) continue;
			if(cur[0] == endNode) {
				break;
			}
			for (int[] next : graph[cur[0]]) {
				int nextDis = cur[1] + next[1];
				if(nextDis < dist[next[0]]) {
					dist[next[0]] = nextDis;
					pq.offer(new int[] {next[0], nextDis});
					p[next[0]] = cur[0];
				}
			}
		}
	}
}
