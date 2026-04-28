import java.io.*;
import java.util.*;

public class Main {

	static char[][] map;
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Map<Integer, Integer> map = new HashMap<>();
    	for (int i = 0; i < N; i++) {
    		int cur = Integer.parseInt(st.nextToken());
    		map.merge(cur, 1, Integer::sum);
		}
    	int M = Integer.parseInt(br.readLine());
    	st = new StringTokenizer(br.readLine());
    	StringBuilder sb = new StringBuilder();
    	for (int i = 0; i < M; i++) {
    		int cur = Integer.parseInt(st.nextToken());
			sb.append(map.getOrDefault(cur, 0)).append(' ');
		}
    	System.out.print(sb.toString());
	}
}