import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static Map<String, Set<String>> graph;
	static Map<String, Integer> indegree;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        graph = new HashMap<>();
        indegree = new HashMap<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
			String A = st.nextToken();
			String B = st.nextToken();
			graph.putIfAbsent(A, new HashSet<>());
			graph.putIfAbsent(B, new HashSet<>());
			indegree.putIfAbsent(A, 0);
			indegree.putIfAbsent(B, 0);
			if (graph.get(A).add(B)) indegree.merge(B, 1, Integer::sum);

		}
        
        PriorityQueue<String> dq = new PriorityQueue<>();

        for (Map.Entry<String, Integer> d : indegree.entrySet()) {
			String key = d.getKey();
			Integer value = d.getValue();
			if(value == 0) dq.offer(key);
		}
        int processed = 0;

        StringBuilder sb = new StringBuilder();
        while(true) {
        	PriorityQueue<String> nextDq = new PriorityQueue<>();
        	while(!dq.isEmpty()) {
            	String cur = dq.poll();
            	sb.append(cur).append('\n');
                processed++;
            	for (String next : graph.get(cur)) {
            		indegree.merge(next, -1, Integer::sum);
            		if(indegree.get(next) == 0) {
            			nextDq.offer(next);
            		}
                }	
            }
        	if(nextDq.isEmpty()) break;
        	dq = nextDq;
        }
        
        
        if (processed != indegree.size()) {
            System.out.println(-1);
        } else {
            System.out.print(sb.toString());
        }

    }
}
