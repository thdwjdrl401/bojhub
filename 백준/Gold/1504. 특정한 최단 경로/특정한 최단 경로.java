import java.io.*;
import java.util.*;

public class Main {
	
	static int N, E;
	static int v1, v2;
	static List<int[]>[] adjList;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        adjList = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
			adjList[i] = new ArrayList<>();
		}
        
        for (int i = 0; i < E; i++) {
        	st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			adjList[a].add(new int[] {b, c});
			adjList[b].add(new int[] {a, c});
		}
        
        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());
        
        int v1ToV2 = dijkstra(v1, v2);
        if(v1ToV2 == Integer.MAX_VALUE) {
        	System.out.println(-1);
        	return;
        }
        
        int sToV1 = dijkstra(1, v1);
        int v2ToN = dijkstra(v2, N);
        
        int v1Fir = sToV1 + v1ToV2 + v2ToN;
        if(sToV1 == Integer.MAX_VALUE || v2ToN == Integer.MAX_VALUE) v1Fir = -1;
        
        int sToV2 = dijkstra(1, v2);
        int v1ToN = dijkstra(v1, N);

        int v2Fir = sToV2 + v1ToV2 + v1ToN;
        if(sToV2 == Integer.MAX_VALUE || v1ToN == Integer.MAX_VALUE) v2Fir = -1;
        
        System.out.println(v1Fir == -1  && v2Fir == -1 ? -1 : v1Fir == -1 ? v2Fir : v2Fir == -1 ? v1Fir : Math.min(v1Fir,  v2Fir));
    }
    
    static int dijkstra(int start, int end) {
    	PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
    		@Override
    		public int compare(int[] a, int[] b) {
    			return Integer.compare(a[1], b[1]);
    		}
    	});
    	pq.offer(new int[] {start, 0});
    	
    	int[] dist = new int[N + 1];
    	Arrays.fill(dist, Integer.MAX_VALUE);
    	dist[start] = 0;
    	
    	while(!pq.isEmpty()) {
    		int[] cur = pq.poll();
    		if(cur[0] == end) break;
    		for (int[] next : adjList[cur[0]]) {
    			int nextWeight = cur[1] + next[1];
    			if(dist[next[0]] > nextWeight) {
    				dist[next[0]] = nextWeight;
    				pq.offer(new int[] {next[0], nextWeight});
    			}
			}
    	}
    	return dist[end];
    }
}