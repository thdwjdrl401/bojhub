import java.io.*;
import java.util.*;

public class Main {

	static char[][] map;
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	int[][] map = new int[N][M];
    	for (int i = 0; i < N; i++) {
    		st = new StringTokenizer(br.readLine());
    		for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
    	int K = Integer.parseInt(br.readLine());
    	StringBuilder sb = new StringBuilder();
        for (int q = 0; q < K; q++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int sum = 0;
            for (int r = i - 1; r <= x - 1; r++) {
                for (int c = j - 1; c <= y - 1; c++) {
                    sum += map[r][c];
                }
            }
            sb.append(sum).append('\n');
        }

    	System.out.println(sb.toString());
    }
}