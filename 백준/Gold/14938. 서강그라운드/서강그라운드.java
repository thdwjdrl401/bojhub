import java.io.*;
import java.util.*;

public class Main {
	
	static int n, m, r;
	static int[] arrT;
	static List<int[]>[] graph;

	public static void main(String args[]) throws Exception	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        arrT = new int[n + 1];
        graph = new ArrayList[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
			arrT[i] = Integer.parseInt(st.nextToken());
		}
        for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph[a].add(new int[] {b, c});
			graph[b].add(new int[] {a, c});
		}
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
        	max = Math.max(max, dijkstra(i));
		}
        System.out.println(max);
    }
	
	static int dijkstra(int start) {
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				return Integer.compare(a[1], b[1]);
			}
		});
		boolean[] visited = new boolean[n + 1];
		int[] dist = new int[n + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
		pq.add(new int[] {start, dist[start], arrT[start]});
		
		int result = 0;
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			if(cur[1] > m) return result;
			if(!visited[cur[0]]) {
				result += arrT[cur[0]];
				visited[cur[0]] = true;
			}
			for (int[] next : graph[cur[0]]) {
				int nextDist = cur[1] + next[1];
				if(nextDist < dist[next[0]]) {
					dist[next[0]] = nextDist;
					pq.offer(new int[] {next[0], nextDist});
				}
			}
		}
		return result;
	}
}