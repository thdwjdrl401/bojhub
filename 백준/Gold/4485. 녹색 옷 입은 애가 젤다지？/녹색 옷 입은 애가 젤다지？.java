import java.io.*;
import java.util.*;

public class Main {
    
	static int N;
	static int[][] map;
	static int[][] coinMap;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static StringBuilder sb = new StringBuilder();
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 1;
        while (true){
        	int result = 0;
        	N = Integer.parseInt(br.readLine());
        	if(N == 0) break;
        	map = new int[N][N];
        	coinMap = new int[N][N];
        	for (int i = 0; i < N; i++) {
				Arrays.fill(coinMap[i], Integer.MAX_VALUE);
			}
        	for (int i = 0; i < N; i++) {
        		StringTokenizer st = new StringTokenizer(br.readLine());
    			for (int j = 0; j < N; j++) {
    				map[i][j] = Integer.parseInt(st.nextToken());
    			}
        	}
        	bfs();
        	result = coinMap[N - 1][N - 1];
        	sb.append("Problem " + T + ": " + result).append('\n');
        	T++;
        }
        System.out.println(sb.toString());
    }
    
    static void bfs() {
    	PriorityQueue<int[]> dq = new PriorityQueue<>(new Comparator<int[]>() {
    		@Override
    		public int compare(int[] a, int[] b) {
    			return Integer.compare(a[2],  b[2]);
    		}
    	});
    	dq.offer(new int[] {0, 0, map[0][0]});
    	coinMap[0][0] = map[0][0];
    	while(!dq.isEmpty()) {
    		int[] cur = dq.poll();
    		int cr = cur[0];
    		int cc = cur[1];
    		int coin = cur[2];
    		if(coin != coinMap[cr][cc]) continue;
    		for (int i = 0; i < 4; i++) {
				int nr = cr + dr[i];
				int nc = cc + dc[i];
				
				if(!check(nr, nc)) continue;
				int nextCoin = map[nr][nc] + coin;
				if(nextCoin < coinMap[nr][nc]) {
					coinMap[nr][nc] = nextCoin;
					dq.offer(new int[] {nr, nc, nextCoin});
				}
			}
    	}
    }
    
    static boolean check(int nr, int nc) {
    	return nr >= 0 && nc >= 0 && nr < N && nc < N;
    }
}