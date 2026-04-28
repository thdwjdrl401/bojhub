import java.io.*;
import java.util.*;


public class Main {
	
	static int[][] arr = new int[26][2];
	static boolean[][] x = new boolean[5][5];
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				int cur = Integer.parseInt(st.nextToken());
				arr[cur][0] = i;
				arr[cur][1] = j;
			}
		}
        
        for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				int cur = Integer.parseInt(st.nextToken());
				x[arr[cur][0]][arr[cur][1]] = true;
				if(isBingo()) {
					int result = i * 5 + j+1;
					System.out.println(result);
					return;
				}
			}
		}
    }
    
    static boolean isBingo() {
    	int count = 0;
		boolean isLRB = true; // \ 빙고
		boolean isRLB = true; // / 빙고
    	for (int i = 0; i < 5; i++) {
    		boolean isColB = true;
    		boolean isRowB = true;

			for (int j = 0; j < 5; j++) {
				if(!x[i][j]) {
					isColB = false;
				}
				if(!x[j][i]) {
					isRowB = false;
				}
			}
			if(isColB) count++;
			if(isRowB) count++;
			if(!x[i][i]) {
				isLRB = false;
			}
			if(!x[4 - i][i]) {
				isRLB = false;
			}
		}
    	if(isLRB) count++;
    	if(isRLB) count++;
    	return count >= 3;
    }
}