import java.io.*;
import java.util.*;

public class Main {

	static int m, n;
	static int[] P, R;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String args[]) throws Exception	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
            
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            if(m == 0 && n == 0) break;
            P = new int[m + 1];
            R = new int[m + 1];
            PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            	@Override
            	public int compare(int[] a, int[] b) {
            		return Integer.compare(a[2], b[2]);
            	}
            });
            for (int i = 0; i <= m; i++) {
    			P[i] = i;
    			R[i] = 1;
    		}
            int result = 0;
            for (int i = 0; i < n; i++) {
    			st = new StringTokenizer(br.readLine());
    			int x = Integer.parseInt(st.nextToken());
    			int y = Integer.parseInt(st.nextToken());
    			int z = Integer.parseInt(st.nextToken());
    			pq.offer(new int[] {x, y, z});
    			result += z;
    		}
            
            int cnt = 0;
            
            while(!pq.isEmpty() && cnt != m -1) {
            	int[] cur = pq.poll();
            	if(union(cur[0], cur[1])) {
            		cnt++;
            		result -= cur[2];
            	}
            }
            sb.append(result).append('\n');
        }
        System.out.println(sb);
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