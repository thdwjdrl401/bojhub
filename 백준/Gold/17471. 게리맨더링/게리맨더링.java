import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[] pop;
	static int[][] link;
	static boolean[] inA;
	static int result = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		pop = new int[N];
		link = new int[N][];
		inA = new boolean[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			pop[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int count = Integer.parseInt(st.nextToken());
			link[i] = new int[count];
			for (int j = 0; j < count; j++) {
				link[i][j] = Integer.parseInt(st.nextToken()) - 1;
			}
		}
		subset(0);
		System.out.println(result == Integer.MAX_VALUE ? -1 : result);
	}
	
	static void subset(int idx) {
		if(idx == N) {
			if(isLinked(inA, true) && isLinked(inA, false)) {
				int sumA = 0, sumB = 0;
				for (int i = 0; i < N; i++) {
					if(inA[i]) sumA += pop[i];
					else sumB += pop[i];
				}
				result = Math.min(result, Math.abs(sumA - sumB));
			}
			return;
		}
		if(idx == 0) {
			inA[idx] = true;
			subset(idx + 1);
			return;
		}
		
		inA[idx] = true;
		subset(idx + 1);
		
		inA[idx] = false;
		subset(idx + 1);
	}
	
	static boolean isLinked(boolean[] inA, boolean target) {
		int start = -1;
		int need = 0;
		
		for (int i = 0; i < N; i++) {
			if(inA[i] == target) {
				need++;
				if(start == -1) start = i;
			}
		}
		if(need == 0) return false;
		
		boolean[] vis = new boolean[N];
		ArrayDeque<Integer> dq = new ArrayDeque<>();
		dq.add(start);
		vis[start] = true;
		
		int cnt = 1;
		while(!dq.isEmpty()) {
			int cur = dq.poll();
			for (int nxt : link[cur]) {
				if(vis[nxt])continue;
				if(inA[nxt] != target) continue;
				vis[nxt] = true;
				dq.add(nxt);
				cnt++;
			}
		}
		return cnt == need;
	}
} 