import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static List<List<Integer>> graph;
	static int[] indegree;
	static int[] result;
	static StringBuilder sb = new StringBuilder();
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        indegree = new int[N + 1];
        result = new int[N + 1];
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine()," ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			graph.get(A).add(B);
			indegree[B]++;
		}
        
        Deque<int[]> dq = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
        	if(indegree[i] == 0) {
        		dq.offer(new int[] {i, 1});
        	}
		}
        while(!dq.isEmpty()) {
        	int[] curArr = dq.poll();
        	int cur = curArr[0];
        	int sem = curArr[1];
        	
        	result[cur] = sem;
        	for (int next : graph.get(cur)) {
				indegree[next]--;
				if(indegree[next] == 0) {
					dq.offer(new int[] {next, sem+1});
				}
			}
        }
        
        for (int i = 1; i <= N; i++) {
			sb.append(result[i]+" ");
		}
        System.out.println(sb.toString());
    }
}
