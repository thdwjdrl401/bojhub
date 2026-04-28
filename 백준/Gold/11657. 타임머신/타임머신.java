import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static List<int[]> graph = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();
    static long INF = Long.MAX_VALUE / 4;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
        	int A = Integer.parseInt(st.nextToken());
        	int B = Integer.parseInt(st.nextToken());
        	int C = Integer.parseInt(st.nextToken());
        	graph.add(new int[] {A, B, C});
		}
        
        long[] dist = new long[N + 1];
        Arrays.fill(dist, INF);
        dist[1] = 0;

        for (int i = 1; i <= N; i++) {
        	boolean updated = false;
           	for (int[] cur : graph) {
    			if(dist[cur[0]] != INF && dist[cur[1]] > dist[cur[0]] + cur[2]) {
    				dist[cur[1]] = dist[cur[0]] + cur[2];
    				updated = true;
    			}
    		}
           	if(!updated) break;
       	}
       	for (int[] cur : graph) {
       		if(dist[cur[0]] != INF && dist[cur[1]] > dist[cur[0]] + cur[2]) {
				System.out.println(-1);
				return;
       		}
       	}

        for (int i = 2; i <= N; i++) {
			sb.append(dist[i] == INF ? -1 : dist[i]).append('\n');
		}
        System.out.println(sb);
    }
}