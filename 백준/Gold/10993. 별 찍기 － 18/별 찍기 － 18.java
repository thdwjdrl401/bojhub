import java.io.*;
import java.util.*;

public class Main {

	static char[][] map;
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
        int H = (1 << N) - 1;
        int W = (1 << (N + 1)) - 3;
    	map = new char[H][W];
    	for(int i = 0; i < H; i++)Arrays.fill(map[i], ' ');
    	
    	if(N % 2 == 0) draw(N, H - 1, W / 2);
    	else draw(N, 0, W / 2);
    	StringBuilder sb = new StringBuilder();
        for (int i = 0; i < H; i++) {
            int last = -1;
            for (int j = W - 1; j >= 0; j--) {
                if (map[i][j] == '*') { last = j; break; }
            }
            for (int j = 0; j <= last; j++) sb.append(map[i][j]);
            sb.append('\n');
        }

		System.out.print(sb.toString());
	}
    
    private static void draw(int N, int c, int r) {
    	if(N == 1) {
    		map[c][r] = '*';
    		return;
    	}
        int H = (1 << N) - 1;
    	if(N % 2 == 1) {
    		for (int i = 0; i < H; i++) {
				map[c + i][r - i] = '*';
    			map[c + i][r + i] = '*';
    		}
    		for (int i = - H + 1; i < H - 1; i++) {
				map[c + H - 1][r + i] = '*';
			}
    		draw(N - 1, c + H - 2, r);
    	}else {
    		for (int i = 0; i < H; i++) {
				map[c - i][r + i] = '*';
    			map[c - i][r - i] = '*';
    		}
    		for (int i = - H + 1; i < H - 1; i++) {
				map[c - H + 1][r + i] = '*';
			}
    		draw(N - 1, c - H + 2, r);
    	}
    }
}