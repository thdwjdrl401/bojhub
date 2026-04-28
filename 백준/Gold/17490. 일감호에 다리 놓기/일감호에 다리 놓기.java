import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static long K;
	static int[] stoneCount;
	static int[] P, R;
	static boolean[] isGongSa;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Long.parseLong(st.nextToken());
		if (M <= 1) {
		    System.out.println("YES");
		    return;
		}
		stoneCount = new int[N + 1];
		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a->a[2]));
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			stoneCount[i] = Integer.parseInt(st.nextToken());
			pq.offer(new int[] {0, i, stoneCount[i]});
		}
		isGongSa = new boolean[N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
		    if ((A == 1 && B == N) || (A == N && B == 1)) isGongSa[N] = true;
		    else isGongSa[Math.min(A, B)] = true;

		}
		
		for (int i = 1; i <= N; i++) {
			if(!isGongSa[i]) {
				int next = (i % N) + 1;
				pq.offer(new int[] {i, next, 0});
			}
		}
		makeSet();
		long min = 0;
		int cnt = 0;
		while(cnt != N) {
			int[] cur = pq.poll();
			
			if(union(cur[0], cur[1])) {
				cnt++;
				min += cur[2];
			}
		}
		if(min > K) System.out.println("NO");
		else System.out.println("YES");
		
	}
	
	static void makeSet() {
		P = new int[N + 1];
		R = new int[N + 1];
		for (int i = 0; i <= N; i++) {
			P[i] = i;
			R[i] = 1;
		}
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
		}
		else { // R[x] >= R[y]
			R[x] += R[y];
			P[y] = x;
		}
		return true;
	}
}