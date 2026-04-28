import java.io.*;
import java.util.*;

public class Main {

	static int T, n, m, t, s, g, h, gh;
	static List<int[]>[] graph;
	static int[] candi;
	static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
        	gh = 0;
        	StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			t = Integer.parseInt(st.nextToken());
			candi = new int[t];

			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken());
			g = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			graph = new ArrayList[n + 1];
			for (int j = 0; j <= n; j++) {
				graph[j] = new ArrayList<>();
			}

			for (int j = 0; j < m; j++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				graph[a].add(new int[] {b, d});
				graph[b].add(new int[] {a, d});
				if(a == g && b == h || a == h && b == g) gh = d;
			}
			for (int j = 0; j < t; j++) {
				int x = Integer.parseInt(br.readLine());
				candi[j] = x;
			}
			
			Arrays.sort(candi);
			int[] distS = dijkstra(s);
			int[] distG = dijkstra(g);
			int[] distH = dijkstra(h);
			for (int j = 0; j < t; j++) {
				int e = candi[j];
				if(distS[g] + distH[e] + gh == distS[e] || distS[h] + distG[e] + gh == distS[e] ) {
					sb.append(e + " ");
				}
			}
			sb.append('\n');
		}
        System.out.println(sb);
    }
    
    static int[] dijkstra(int start) {
    	int[] dist = new int[n + 1];
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
    		if(cur[1] > dist[cur[0]]) continue;
    		for(int[] next : graph[cur[0]]) {
    			int nextDist = cur[1] + next[1];
    			if(nextDist < dist[next[0]]) {
    				dist[next[0]] = nextDist;
    				pq.offer(new int[] {next[0], nextDist});
    			}
    		}
    	}
    	return dist;
    }
}