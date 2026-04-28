import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static boolean[][] map = new boolean[100][100];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int r= Integer.parseInt(st.nextToken());
        	int c= Integer.parseInt(st.nextToken());
        	
        	for (int j = 0; j < 10; j++) {
        		for (int j2 = 0; j2 < 10; j2++) {
        			map[r+j][c+j2] = true;
				}
			}
		}
        int count = 0;
        for (int i = 0; i < 100; i++) {
        	for (int j = 0; j < 100; j++) {
        		if(map[i][j]) {
        			if(i == 0 || !map[i - 1][j]) count++;
        			if(j == 0 || !map[i][j - 1]) count++;
        		}
			}
		}
        System.out.println(count*2);
    }
}