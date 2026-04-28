import java.util.*;
import java.io.*;

public class Main {
	static int R;
	static int C;
	static int sc;
	static int[] dc = {0, 1, 0, -1};
	static int[] dr = {-1, 0, 1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		int d = 2 * (C + R);
		sc = Integer.parseInt(br.readLine());
		
		int[] p = new int[sc];
		for (int i = 0; i < sc; i++) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			if(dir == 1) p[i] = x;
			else if(dir == 4) p[i] = C + x;
			else if(dir == 2) p[i] = C + R + (C - x);
			else if(dir == 3) p[i] = 2 * (C + R) - x;
		}
		st = new StringTokenizer(br.readLine());
		
		int dir = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		if(dir == 1) {}
		else if(dir == 4) x = C + x;
		else if(dir == 2) x = C + R + (C - x);
		else if(dir == 3) x = 2 * (C + R) - x;
		
		int minSum = 0;
		for (int i = 0; i < sc; i++) {
			int cur = p[i];
			int diff = Math.abs(cur - x);
			diff = Math.min(d - diff, diff);
			minSum += diff;
		}
		System.out.println(minSum);
	}
}
