import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static List<Integer>[] tree;
	static int[] parrent;
	static StringBuilder sb = new StringBuilder();
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		tree = new ArrayList[N + 1];
		parrent = new int[N+1];
		visited = new boolean[N+1];
		for (int i = 0; i < N + 1; i++) {
			tree[i] = new ArrayList<>();
		}
		for (int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			tree[a].add(b);
			tree[b].add(a);
		}
		visited[1] = true;
		dfs(1);
		for (int i = 2; i <= N; i++) {
			sb.append(parrent[i]).append('\n');
		}
		System.out.println(sb);
	}
	static void dfs(int start) {
		
		List<Integer> cur = tree[start];
		for (int next : cur) {
			if(visited[next]) continue;
			visited[next] = true;
			parrent[next] = start;
			dfs(next);
		}
	}
}
