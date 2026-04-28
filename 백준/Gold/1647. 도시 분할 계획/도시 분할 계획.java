import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static int[] P, R;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a->a[2]));
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			pq.offer(new int[] {A, B, C});
		}

		makeSet();
		
		
		long min = 0;
		int cnt = 0;
        int maxEdge = 0;

		
		while(cnt != N -1) {
			int[] cur = pq.poll();
			if (cur == null) break;	
			if(union(cur[0], cur[1])) {
				cnt++;
				min += cur[2];
                if (cur[2] > maxEdge) maxEdge = cur[2];

			}
		}
		System.out.println(min - maxEdge);
	
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
	
	static int find(int x) {
		if(P[x] == x) return P[x];
		return P[x] = find(P[x]);
	}
	
	static void makeSet() {
		P = new int[N + 1];
		R = new int[N + 1];
		
		for (int i = 0; i <= N; i++) {
			P[i] = i;
			R[i] = 1;
		}
	}
}