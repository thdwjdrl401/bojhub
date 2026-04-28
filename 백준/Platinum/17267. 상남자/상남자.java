import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int L, R;
	static int[][] map;
	static int sr, sc;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int max = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j) - '0';
				if(map[i][j] == 2) {
					map[i][j] = 0;
					sr = i;
					sc = j;
				}
			}
		}
		bfs();
		System.out.println(max);
	}

	static void bfs() {
		Deque<int[]> dq = new ArrayDeque<>();
        int[][] bestLeft = new int[N][M];
        for (int i = 0; i < N; i++) {
			Arrays.fill(bestLeft[i],  -1);
		}
        
		dq.offer(new int[] {sr, sc, L});
		bestLeft[sr][sc] = L;
		while(!dq.isEmpty()) {
			int[] cur = dq.poll();
			int r = cur[0];
			int c = cur[1];
			int remainL = cur[2];
            if (remainL != bestLeft[r][c]) continue;
            int leftUsed = L - remainL;
            int rightUsed = leftUsed + (c - sc);
            int remainR = R - rightUsed;
            if (remainL < 0 || remainR < 0) continue;

			for (int dir = 0; dir < 4; dir++) {
				int nr = cur[0] + dr[dir];
				int nc = cur[1] + dc[dir];
				if(!check(nr, nc)) continue;
				if(map[nr][nc] == 1) continue;
				
                int nRemainL = remainL;
                if (dir == 2) { // 왼쪽방향일때
                    if (remainL == 0) continue; // 남아있는지 확인하고 없으면 껀띠뉴~
                    nRemainL = remainL - 1;
                }

                int nLeftUsed = L - nRemainL;
                int nRightUsed = nLeftUsed + (nc - sc);
                int nRemainR = R - nRightUsed;
                if (nRemainR < 0) continue;

                if (nRemainL <= bestLeft[nr][nc]) continue;
                bestLeft[nr][nc] = nRemainL;

                if (dir == 2) dq.addLast(new int[]{nr, nc, nRemainL});
                else dq.addFirst(new int[]{nr, nc, nRemainL});
			}
			
		}	
		
		int ans = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                int remainL = bestLeft[r][c];
                if (remainL < 0) continue;

                int leftUsed = L - remainL;
                int rightUsed = leftUsed + (c - sc);
                if (rightUsed < 0) continue;
                if (leftUsed <= L && rightUsed <= R) ans++;
            }
        }
        max = ans;
	}
	
	
	static boolean check(int r, int c) {
		return r < N && c < M && r >= 0 && c >= 0;
	}
}
