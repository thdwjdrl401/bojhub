import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static int[] P, R;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
		P = new int[N + 1];
		R = new int[N + 1];
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			pq.offer(new int[] {a, b, c});
		}
		
		for (int i = 0; i <= N; i++) {
			P[i] = i;
			R[i] = 1;
		}
		int min = 0;
		int cnt = 0;
		while(cnt != N - 1) {
			int[] cur = pq.poll();
			if(union(cur[0], cur[1])) {
				cnt++;
				min += cur[2];
			}
		}
		System.out.println(min);
	}
	
	static int find(int x) {
		if(x == P[x]) return P[x];
		return P[x] = find(P[x]);
	}
	
	static boolean union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x == y) return false;
		if(R[x] < R[y]) {
			R[y] += R[x];
			P[x] = y;
		} else {
			R[x] += R[y];
			P[y] = x;
		}
		
		return true;
	}
}