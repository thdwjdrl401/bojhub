import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static int[][] position;
	static int[] parents;
	static int[] rank;

	static class Node implements Comparable<Node>{
		int idx;
		int next;
		double dist;
		
		Node(){}
		Node(int idx, int next, double dist){
			this.idx = idx;
			this.next = next;
			this.dist = dist;
		}
		
		@Override
		public int compareTo(Node o) {
			return Double.compare(this.dist, o.dist);
		}
	}
	
	public static void main(String args[]) throws Exception	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        position = new int[N + 1][2];
        
        for (int i = 1; i <= N; i++) {
        	st = new StringTokenizer(br.readLine());
			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			position[i][0] = X;
			position[i][1] = Y;
		}
		PriorityQueue<Node> pq = new PriorityQueue<>();

        makeSet();
        int cnt = 0;
        for (int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(union(a, b)) cnt++;
		}
        
        for (int i = 1; i <= N; i++) {
			for (int j = i + 1; j <= N; j++) {
				double dist = getDist(position[i][0], position[i][1], position[j][0], position[j][1]);
				pq.offer(new Node(i, j, dist));
			}
		}
        double result = 0;
        
        while(!pq.isEmpty() && cnt != N - 1) {
        	Node cur = pq.poll();
        	
        	if(union(cur.idx, cur.next)) {
        		result += cur.dist;
        		cnt++;
        	}
        }
        System.out.printf("%.2f", result);
	}
	
	public static void makeSet() {
		parents = new int[N + 1];
		rank = new int[N + 1];
		for (int i = 0; i <= N; i++) {
			parents[i] = i;
			rank[i] = 1;
		}
	}
	
	public static int find(int x) {
		if(parents[x] == x) return parents[x];
		return parents[x] = find(parents[x]);
	}
	
	public static boolean union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x == y) return false;
		if(rank[x] < rank[y]) {
			rank[y] += rank[x];
			parents[x] = y;
		} else {
			rank[x] += rank[y];
			parents[y] = x;
		}
		return true;
	}
	
	
	public static double getDist(int x1, int y1, int x2, int y2) {
		long dx = x1 - x2;
		long dy = y1 - y2;
		return Math.sqrt(dx*dx + dy*dy);
	}
}