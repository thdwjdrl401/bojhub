import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static int[] result;
	static List<List<Integer>> graph;
	static int[] indegree;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        result = new int[N+1];
        indegree = new int[N+1];
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}
        for (int i = 1; i <= N; i++) {
        	result[i] = i;
        }
        M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			graph.get(A).add(B);
			indegree[B]++;
		}
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
			if(indegree[i] == 0) dq.offer(i);
		}
        StringBuilder sb = new StringBuilder();
        while(!dq.isEmpty()) {
        	int cur = dq.poll();
        	
        	sb.append(cur).append(' ');
        	for (int i = 0; i < graph.get(cur).size(); i++) {
				int next = graph.get(cur).get(i);
				indegree[next]--;
				if(indegree[next] == 0) dq.offer(next);
			}
        }
        
        System.out.println(sb.toString());
        
    }
}
