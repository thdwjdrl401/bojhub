import java.io.*;
import java.util.*;

public class Main {

	static char[][] map;
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	
    	map = new char[N][M];
    	for (int i = 0; i < N; i++) 	{
    		String line = br.readLine();
    		for (int j = 0; j < M; j++) {
    			map[i][j] = line.charAt(j);
			}
		}
    	int min = Integer.MAX_VALUE;
    	for (int i = 0; i < N - 7; i++) 	{
    		for (int j = 0; j < M - 7; j++) {
    			min = Math.min(min, Math.min(getMismatch('B', i, j), getMismatch('W', i, j)));
			}
    	}
    	System.out.println(min);
	}
    
    private static int getMismatch(char color, int startC, int startR) {
    	int count = 0;
    	for (int i = 1; i <= 8; i++) {
			for (int j = 1; j <= 8; j++) {
				char cur = map[startC + i - 1][startR + j - 1];
				if((i % 2 == 1 && j % 2 == 1) || (i % 2 == 0 && j % 2 == 0)) {
					if(cur != color) count++;
				} else {
					if(cur == color) count++;
				}
			}
		}
    	return count;
    }
}