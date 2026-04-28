import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int pair = Integer.parseInt(br.readLine());
		boolean[] visited = new boolean[N + 1];
		int[][] arr = new int[N + 1][N + 1];
		for (int i = 0; i < pair; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			arr[n1][n2] ++;
			arr[n2][n1] ++;
		}
		Deque<Integer> dq = new ArrayDeque<>();
		int count = 0;
		dq.offer(1);
		visited[1] = true;
		while(!dq.isEmpty()) {
			int cur = dq.poll();
			for (int i = 1; i <= N; i++) {
				int num = arr[cur][i];
				if(num != 0 && !visited[i]) {
					visited[i] = true;
					dq.offer(i);
					count++;
				}
			}
		}
		System.out.println(count);
	}
}