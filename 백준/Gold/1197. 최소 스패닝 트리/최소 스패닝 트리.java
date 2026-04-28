import java.io.*;
import java.util.*;

public class Main {
// 프림으로 해보자해보자 커피설탕프림
	static int V, E;
	static List<int[]>[] graph;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		graph = new ArrayList[V + 1];
		visited = new boolean[V + 1];
		for (int i = 0; i <= V; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph[a].add(new int[] {b, c});
			graph[b].add(new int[] {a, c});
		}
		int result = prim(1);
		System.out.println(result);
	}
	
	static int prim(int start) {
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[1], o2[1]);
			}
		});
		pq.offer(new int[] {start, 0});
		
		int totalWeight = 0;
		int count = 0;
		
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			if(visited[cur[0]]) continue;
			
			visited[cur[0]] = true;
			totalWeight += cur[1];
			count++;
			
			if(count == V) break;
			
			for (int[] next : graph[cur[0]]) {
				if(!visited[next[0]]) {
					pq.offer(next);
				}
			}
		}
		return totalWeight;
	}
}
