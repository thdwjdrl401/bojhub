import java.io.*;
import java.util.*;

public class Main {

	static int n;
	static double[][] stars;
	static int[] P, R;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		P = new int[n+1];
		R = new int[n+1];
		for (int i = 0; i <= n; i++) {
			P[i] = i;
			R[i] = 1;
		}
		stars = new double[n+1][2];
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			double a = Double.parseDouble(st.nextToken());
			double b = Double.parseDouble(st.nextToken());
			stars[i][0] = a;
			stars[i][1] = b;
		}
		
		for (int i = 1; i <= n; i++) {
			double[] a = stars[i];
		    for (int j = i + 1; j <= n; j++) {
				double[] b = stars[j];
				pq.offer(new Edge(i, j, getDistance(a, b)));
			}
		}
		
		int cnt = 0;
		double sum = 0d;
		while(cnt != n - 1) {
			Edge cur = pq.poll();
			if(cur == null) break;
			if(union(cur)) {
				cnt++;
				sum += cur.distance;
			}
		}
		System.out.printf("%.2f\n", sum);
		
	}
	
	static class Edge implements Comparable<Edge>{
		int a;
		int b;
		double distance;
		
		@Override
		public int compareTo(Edge e) {
			return Double.compare(this.distance, e.distance);
		}
		
		public Edge() {}
		
		public Edge(int a, int b, double distance) {
			this.a = a;
			this.b = b;
			this.distance = distance;
		}
	}
	
	static double getDistance(double[] a, double[] b) {
		double dx = a[0] - b[0];
		double dy = a[1] - b[1];
		return Math.sqrt(dx*dx + dy*dy);
	}
	
	static int find(int x) {
		if(P[x] == x) return P[x];
		return P[x] = find(P[x]);
	}
	static boolean union(Edge e) {
		int x = find(e.a);
		int y = find(e.b);
		
		if(x == y) return false;
		if(R[x] < R[y]) {
			R[y] += R[x];
			P[x] = y;
		}else {
			R[x] += R[y];
			P[y] = x;
		}
		return true;
	}
}