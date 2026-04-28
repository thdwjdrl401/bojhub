import java.io.*;
import java.util.*;

public class Main {

	static int TC;
	static int N, M, W;
	static List<int[]> graph;
	
    public static void main(String args[]) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	TC = Integer.parseInt(br.readLine());
    	StringBuilder sb = new StringBuilder();
    	for (int t = 0; t < TC; t++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());	
    		N = Integer.parseInt(st.nextToken());
    		M = Integer.parseInt(st.nextToken());
    		W = Integer.parseInt(st.nextToken());
    		
    		graph = new ArrayList<>();
    		for (int i = 0; i < M; i++) {
        		st = new StringTokenizer(br.readLine());	
    			int S = Integer.parseInt(st.nextToken());
        		int E = Integer.parseInt(st.nextToken());
        		int T = Integer.parseInt(st.nextToken());
        		
        		graph.add(new int[] {S, E, T});
        		graph.add(new int[] {E, S, T});
			}
    		for (int i = 0; i < W; i++) {
        		st = new StringTokenizer(br.readLine());	
    			int S = Integer.parseInt(st.nextToken());
        		int E = Integer.parseInt(st.nextToken());
        		int T = Integer.parseInt(st.nextToken());
        		graph.add(new int[] {S, E, -T});
			}
    		if(vp()) sb.append("YES\n");
    		else sb.append("NO\n");
		}
    	System.out.println(sb);
    }
    
    static boolean vp() {
    	int[] dist = new int[N + 1];
    	Arrays.fill(dist, 0);
    	
    	for (int i = 1; i <= N; i++) {
    		boolean updated = false;
    		for (int[] next : graph) {
				if(dist[next[1]] > dist[next[0]] + next[2]) {
					dist[next[1]] = dist[next[0]] + next[2];
					updated = true;
					
					if(i == N) return true;
				}
			}
    		if(!updated) break;
		}
    	return false;
    }
}