import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int[][] map;
	static List<int[]> oneList = new ArrayList<>();
	static PriorityQueue<Edge> pq;
	static int[] P;
	static int[] R;
	
	
	static class EdgeComparator implements Comparator<Edge>{

		@Override
		public int compare(Edge o1, Edge o2) {
			return Integer.compare(o1.distance, o2.distance);
		}
		
	}
	static class Edge{
		int startNode;
		int endNode;
		int distance;
		
		public Edge() {}
		public Edge(int s, int e, int d) {
			this.startNode = s;
			this.endNode = e;
			this.distance = d;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					map[i][j] = -1;
					oneList.add(new int[] {i, j});
				}
			}
		}
		
		int iCount = floodFill() - 1;
		P = new int[iCount + 1];
		R = new int[iCount + 1];
		for (int i = 0; i <= iCount; i++) {
			P[i] = i;
			R[i] = 1;
		}
//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
//		System.out.println(iCount);
		pq = new PriorityQueue<>(new EdgeComparator());
		findCandi();

		int min = 0;
		int cnt = 0;
		while(cnt != iCount - 1) {
			Edge cur = pq.poll();
			if(cur == null) {
				min = -1;
				break;
			}
			if(union(cur.startNode, cur.endNode)) {
				cnt++;
				min += cur.distance;
			}
		}
		
		System.out.println(min);
//		while(!pq.isEmpty()) {
//			int[] cur = pq.poll();
//			System.out.println(cur[0] + " " + cur[1] + " " + cur[2]);	
//		}
		
		
	}
	static boolean union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x == y) return false;
		if(x < y) {
			R[y] += R[x];
			P[x] = y;
		}else {
			R[x] += R[y];
			P[y] = x;
		}
		return true;
	}
	
	static int find(int x) {
		if(x == P[x]) return x;
		return P[x] = find(P[x]);
	}
	
	static void findCandi() {
		for (int i = 0; i < oneList.size(); i++) {
			int[] point = oneList.get(i);
			int startNode = map[point[0]][point[1]];
			
			for (int j = 0; j < 4; j++) {
				int nr = point[0];
				int nc = point[1];
				int distance = 0;
				while(true) {
					nr += dr[j];
					nc += dc[j];
					if(!check(nr, nc)) break;
					if(map[nr][nc] == startNode) break;
					if(map[nr][nc] != 0) {
						if(distance < 2) break;
						int endNode = map[nr][nc];
						pq.offer(new Edge(startNode, endNode, distance));
						break;
					}
					distance++;
				}
			}
		}
	}
	
	static int floodFill() {
		int count = 1;
		Deque<int[]> dq = new ArrayDeque<>();
		boolean[][] visited = new boolean[N][M];
		for (int i = 0; i < oneList.size(); i++) {
			int[] point = oneList.get(i);
			if(visited[point[0]][point[1]]) continue;
			dq.offer(point);
			map[point[0]][point[1]] = count;
			visited[point[0]][point[1]] = true;
			
			while(!dq.isEmpty()) {
				int[] curPoint = dq.poll();
				
				for (int d = 0; d < 4; d++) {
					int nr = curPoint[0] + dr[d];
					int nc = curPoint[1] + dc[d];
					if(!check(nr, nc)) continue;
					if(visited[nr][nc]) continue;
					if(map[nr][nc] != -1) continue;
					dq.offer(new int[] {nr, nc});
					visited[nr][nc] = true;
					map[nr][nc] = count;
				}
			}
			count++;
		}
		return count;
	}
	
	static boolean check(int r, int c) {
		return r < N && c < M && r >= 0 && c >= 0;
	}
}