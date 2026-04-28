import java.io.*;
import java.util.*;

public class Main {

	static int N, M, K, X;
	static List<List<Integer>> list;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		list = new ArrayList<>();
		visited = new boolean[N + 1];
		
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			list.get(A).add(B);
		}
		
		PriorityQueue<Integer> dq = new PriorityQueue<>();
		dq.offer(X);
		visited[X] = true;
		int index = 0;
		while(++index <= K) {
			PriorityQueue<Integer> nextDq = new PriorityQueue<>();
			while(!dq.isEmpty()){
				int curNum = dq.poll();
				List<Integer> curList = list.get(curNum);
				for (int next : curList) {
					if(visited[next]) continue;
					visited[next] = true;
					nextDq.offer(next);
				}
			}
			if(nextDq.isEmpty()) break;
			dq = nextDq;
			if(index == K) {
				while(!dq.isEmpty()) {
					sb.append(dq.poll()).append(" ");					
				}
				break;
			}
		}

		if(sb.length() == 0) System.out.println(-1);
		else System.out.println(sb);
	}
}
