import java.util.*;
import java.io.*;

class Main {
	static int N;
	static int[][] arr;
	static int[] sequence = new int[9];
	static boolean[] visited = new boolean[10];
	static int max = Integer.MIN_VALUE;
	
	public static void main(String args[]) throws Exception	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][9];
		int totalScore = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		getList(1);
		System.out.println(max);
	}
	
	static int getScore(int[] order) {
		int score = 0;
		int index = 0;
		for (int inning = 0; inning < N; inning++) {
			int outCount = 0;
			int base = 0;
			while(outCount < 3) {
				int player = order[index]; 
                int result = arr[inning][player - 1];
				if(result != 0) {
					base = base<<result | 1 << (result - 1);	
					
					score += Integer.bitCount(base >> 3);
					base = base & 7;
				} else {
					outCount++;
				}
				index = (index + 1) % 9;
			}
		}
		return score;
	}
	
	static void getList(int depth) {
		if(depth == 9) {
			int[] result = new int[9];
			for (int i = 1; i < 9; i++) {
				if(i < 4) result[i - 1] = sequence[i];
				else if(i >= 4) result[i] = sequence[i];
			}
			result[3] = 1;
			max = Math.max(max, getScore(result));
			return;
		}
		for (int i = 2; i <= 9; i++) {                                                          
			if(visited[i])continue;
			visited[i] = true;
			sequence[depth] = i;
			getList(depth + 1);
			visited[i] = false;
		}
	}
}