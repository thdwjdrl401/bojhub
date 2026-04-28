import java.io.*;
import java.util.*;

public class Main {
    
	static int N;
	static int[][] map;
	static int blue = 0;
	static int white = 0;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine() );
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	for (int j = 0; j < N; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
        
        dfs(0, 0, N, N);
        
        System.out.println(white);
        System.out.println(blue);
    }
    
    static void dfs(int sr, int sc, int er, int ec) {
    	int x = map[sr][sc];
    	for (int i = sr; i < er; i++) {
    		for (int j = sc; j < ec; j++) {
				if(map[i][j] != x) {
					int halfR = (er - sr) / 2;
					int halfC = (ec - sc) / 2;
					dfs(sr, sc, sr + halfR, sc + halfC);
					dfs(sr, sc + halfC, sr + halfR, ec);
					dfs(sr + halfR, sc, er, sc + halfC);
					dfs(sr + halfR, sc + halfC, er, ec);
					return;
				}
			}
		}
    	if(x == 1) blue++;
		else white++;
    }
}
