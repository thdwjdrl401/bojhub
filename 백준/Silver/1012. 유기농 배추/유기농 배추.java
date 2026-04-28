import java.io.*;
import java.util.*;

public class Main {
	static int M;
	static int N;
	static int[] dx = {0, 1, 0, -1}; 
	static int[] dy = {-1, 0, 1, 0};
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int T = Integer.parseInt(br.readLine());
    	for (int test_case = 0; test_case < T; test_case++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		M = Integer.parseInt(st.nextToken());
    		N = Integer.parseInt(st.nextToken());
    		int K = Integer.parseInt(st.nextToken());
    		int[][] map = new int[N][M];
    		int[][] pos = new int[K][2];
    		for (int k = 0; k < K; k++) {
    			st = new StringTokenizer(br.readLine());
    			int X = Integer.parseInt(st.nextToken()); 
    			int Y = Integer.parseInt(st.nextToken());
    			pos[k][0] = X;
    			pos[k][1] = Y;
    			map[Y][X] = 1;
			}
    		Deque<int[]> dq = new ArrayDeque<>();
    		int count = 0;
    		for (int i = 0; i < K; i++) {
				int curX = pos[i][0];
				int curY = pos[i][1];
				if(!check(curX, curY)) continue;
				if(map[curY][curX] != 1) continue;
				dq.offer(new int[] {curX, curY});
				while(!dq.isEmpty()){
					int[] next = dq.poll();
					for (int j = 0; j < 4; j++) {
						int nX = next[0] + dx[j];
						int nY = next[1] + dy[j];
						if(!check(nX, nY)) continue;
						if(map[nY][nX] != 1) continue;
						map[nY][nX] = 2;
						dq.offer(new int[] {nX, nY});
					}
				}
				count++;
			}
    		System.out.println(count);
		}
    }
    
    static boolean check(int x, int y) {
    	return x >= 0 && y >= 0 && x < M && y < N;
    }
}
