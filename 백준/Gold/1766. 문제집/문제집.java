import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static List<List<Integer>> graph;
	static int[] indegree;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new ArrayList<>();
		indegree = new int[N + 1];
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			graph.get(A).add(B);
			indegree[B]++;
		}

		PriorityQueue<Integer> dq = new PriorityQueue<>();

		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0) {
				dq.offer(i);
			}
				
		}
		while (!dq.isEmpty()) {
			int cur = dq.poll();
			sb.append(cur).append(' ');
			for (int next : graph.get(cur)) {
				indegree[next]--;
				if (indegree[next] == 0) {
					dq.offer(next);
				}
			}
		}

		for (int i = 1; i <= N; i++) {
			if (indegree[i] > 0)
				sb.append(i + " ");
		}

		System.out.println(sb);
	}
}
