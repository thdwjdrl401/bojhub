import java.util.*;
import java.io.*;

class Main {
	static int N;
	static int[][] map;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String args[]) throws Exception	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int n = 0; n < N; n++) {
			int x = Integer.parseInt(br.readLine());
			
			if(x == 0) {
				if(!pq.isEmpty()) sb.append(pq.poll()).append('\n');
				else sb.append(0).append('\n');
			}else {
				pq.offer(x);
			}
		}
		System.out.println(sb.toString());
	}
}