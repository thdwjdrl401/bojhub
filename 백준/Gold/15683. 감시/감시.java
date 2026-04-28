import java.io.*;
import java.util.*;

public class Main {
    
	static int N, M;
	static int[][] map;
	static int min = Integer.MAX_VALUE;
    static int blind = 0;
	static List<int[]> cctvList = new ArrayList<>();
	static int[][][][] sight = {
			{},
			{ {{-1}, {0}}, {{0}, {1}}, {{1}, {0}}, {{0}, {-1}} },
			{ {{0, 0}, {1, -1}}, {{-1, 1}, {0, 0}} },
			{ {{-1, 0}, {0, 1}}, {{0, 1}, {1, 0}}, {{1, 0}, {0, -1}}, {{0, -1}, {-1, 0}} },
			{ {{-1, 0, 0}, {0, 1, -1}}, {{-1, 0, 1}, {0, 1, 0}}, {{1, 0, 0}, {0, 1, -1}}, {{-1, 1, 0}, {0, 0, -1}} },
			{ {{-1, 0, 0, 1}, {0, 1, -1, 0}} }
	};
	
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
        		if(map[i][j] >= 1 && map[i][j] <= 5) cctvList.add(new int[] {i, j, map[i][j]});
                if (map[i][j] == 0) blind++;
			}
		}
        dfs(0);
        System.out.println(min);
    }
    
    static void dfs(int depth) {
    	if(depth == cctvList.size()) {
            min = Math.min(min, blind);
    		return;
    	}
	
		int[] cur = cctvList.get(depth);
		int cr = cur[0];
		int cc = cur[1];
		int level = cur[2];
		int[][][] cctv = sight[level];
		for (int j = 0; j < cctv.length; j++) {
			int[][] cctvSight = cctv[j];
	        ArrayList<int[]> changed = new ArrayList<>();
	        apply(cctvSight, cr, cc, changed);
			dfs(depth + 1);
			rollback(changed);
		}
    }
    
    static void apply(int[][] cctvSight, int r, int c, ArrayList<int[]> changed) {
        for (int k = 0; k < cctvSight[0].length; k++) {
            int dr = cctvSight[0][k], dc = cctvSight[1][k];
            int nr = r + dr, nc = c + dc;

            while (check(nr, nc) && map[nr][nc] != 6) {
                if (map[nr][nc] == 0) {
                    map[nr][nc] = 8;
                    blind--;
                    changed.add(new int[]{nr, nc});
                }
                nr += dr; nc += dc;
            }
        }
    }

    static void rollback(ArrayList<int[]> changed) {
        for (int[] p : changed) {
            blind++;
            map[p[0]][p[1]] = 0;
        }
    }

    
    static boolean check(int nr, int nc) {
    	return nr >= 0 && nc >= 0 && nr < N && nc < M;
    }
}
