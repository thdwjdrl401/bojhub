import java.io.*;
import java.util.*;

public class Main {
	static int R, C;
	static char[][] map;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static boolean[] alphabet = new boolean[26];
	static int max = 0;
    
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        for (int r = 0; r < R; r++) {
        	String s = br.readLine();
			for (int c = 0; c < C; c++) {
				map[r][c] = s.charAt(c);
			}
        }
        alphabet[map[0][0] -'A'] = true;
        dfs(0, 0, 1);
        System.out.println(max);
    }
    
    static void dfs(int r, int c, int count) {
    	max = Math.max(max, count);
    	for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if(!check(nr, nc)) continue;
			char curC = map[nr][nc];
			if(alphabet[curC - 'A']) continue;
			alphabet[curC - 'A'] = true;
			dfs(nr, nc, count+1);
			alphabet[curC - 'A'] = false;
		}
    }
    
    static boolean check(int nr, int nc) {
    	return nr >= 0 && nc >= 0 && nr < R && nc < C;
    }
}