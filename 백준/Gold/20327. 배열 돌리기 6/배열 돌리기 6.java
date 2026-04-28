import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int size;
	static int R;
	static int[][] map;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		size = 1 << N;
		map = new int[size][size];
		for (int i = 0; i < size; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < size; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			apply(k, l);
		}
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                sb.append(map[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);
	}
	
	static void apply(int k, int l) {
		int s = 1 << l;
		int[][] b = new int[size][size];
		if(k >= 1 && k <= 4) {
			for (int i = 0; i < size; i+= s) {
				for (int j = 0; j < size; j+=s) {
					transformInsideBlock(k, i, j, s, b);
				}
			}
		}else {
			int blocks = size / s;
			for (int i = 0; i < blocks; i++) {
				for (int j = 0; j < blocks; j++) {
					int ni = i, nj = j;
					if(k == 5) {
						ni = blocks - 1 - i;
						nj = j;
					} else if (k == 6) {
						ni = i;
						nj = blocks - 1 - j;
					} else if (k == 7) {
						ni = j;
						nj = blocks - 1 - i;
					} else if (k == 8) {
						ni = blocks - 1 - j;
						nj = i;
					}
					copyBlock(i * s, j * s, ni * s, nj * s, s, b);
				}
			}
		}
		map = b;
	}
	
	static void copyBlock(int fromR, int fromC, int toR, int toC, int s, int[][] b) {
	    for (int i = 0; i < s; i++) {
	        System.arraycopy(map[fromR + i], fromC, b[toR + i], toC, s);
	    }
	}

	static void transformInsideBlock(int k, int bi, int bj, int s, int[][] b) {
		for (int i = 0; i < s; i++) {
			for (int j = 0; j < s; j++) {
				int r = bi + i;
				int c = bj + j;
				int di = i, dj = j;
				if(k == 1) {
					di = s - 1 - i;
				} else if(k == 2){
					dj = s - 1 - j; 
				} else if(k == 3){
					di = j;
					dj = s - 1 - i;
				} else if(k == 4) {
					di = s - 1 - j;
					dj = i;
				}
				b[bi + di][bj + dj] = map[r][c];
			}
		}
	}
}