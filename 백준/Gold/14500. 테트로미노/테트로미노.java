import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
    static int[][] map;
    static int[][][][] type = {
    		{{{0, 0, 0, 0}, {0, 1, 2, 3}}, {{0, 1, 2, 3}, {0, 0, 0, 0}}},
    		{{{0, 0, 1, 1}, {0, 1, 0, 1}}},
    		{{{0, 1, 2, 2}, {0, 0, 0, 1}}, {{1, 1, 1, 0}, {0, 1, 2, 2}}, {{0, 0, 1, 2}, {0, 1, 1, 1}}, {{0, 0, 0, 1}, {0, 1, 2, 0}}, {{0, 1, 2, 2}, {1, 1, 1, 0}}, {{0, 1, 1, 1}, {0, 0, 1, 2}}, {{0, 0, 1, 2}, {0, 1, 0, 0}}, {{0, 0, 0, 1}, {0, 1, 2, 2}}},
    		{{{0, 1, 1, 2}, {0, 0, 1, 1}}, {{0, 0, 1, 1}, {1, 2, 0, 1}}, {{0, 1, 1, 2}, {1, 1, 0, 0}}, {{0, 0, 1, 1}, {0, 1, 1, 2}}},
    		{{{0, 0, 0, 1}, {0, 1, 2, 1}}, {{0, 1, 2, 1}, {0, 0, 0, 1}}, {{1, 1, 1, 0}, {0, 1, 2, 1}}, {{0, 1, 2, 1}, {1, 1, 1, 0}}}
    };
    static int max = Integer.MIN_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
        
        for (int i = 0; i < N; i++) {
        	for (int j = 0; j < M; j++) {
        		for (int t = 0; t < 5; t++) {
        			int[][][] types = type[t];
					for (int k = 0; k < types.length; k++) {
						int[][] spin = types[k];
						boolean isNotOutOfBounds = true;
						int sum = 0;
						for (int d = 0; d < 4; d++) {
							int nr = i + spin[0][d];
							int nc = j + spin[1][d];
							if(!check(nr, nc)) {
								isNotOutOfBounds = false;
								break;
							}
							sum += map[nr][nc];
						}
						if(!isNotOutOfBounds)continue;
						max = Math.max(max, sum);
					}
				}
			}
		}
        System.out.println(max);
    }
    static boolean check(int nr, int nc) {
    	return nr >= 0 && nc >= 0 && nr < N && nc < M;
    }
}