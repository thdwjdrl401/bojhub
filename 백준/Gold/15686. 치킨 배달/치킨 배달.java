import java.util.*;
import java.io.*;

class Main {
	static int N;
	static int M;
	static int[][] map;
	static StringBuilder sb = new StringBuilder();
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static List<int[]> cList = new ArrayList<>();
	static List<int[]> hList = new ArrayList<>();
	static boolean[] aliveCList;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String args[]) throws Exception	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if(map[r][c] == 2)cList.add(new int[] {r, c});
				else if(map[r][c] == 1)hList.add(new int[] {r, c});
			}
		}
		aliveCList = new boolean[cList.size()];
		dfs(0, 0);
		
		System.out.println(min);
	}
	static void dfs(int depth, int start){
		if(depth == M) {
			min = Math.min(min, getD());
			return;
		}
		for (int i = start; i < cList.size(); i++) {
			if(aliveCList[i]) continue;
			aliveCList[i] = true;
			dfs(depth + 1, i + 1);
			aliveCList[i] = false;
		}
	}
	
	static int getD() {
		int resultSum = 0;
		for (int i = 0; i < hList.size(); i++) {
			int minD = Integer.MAX_VALUE;
			for (int j = 0; j < cList.size(); j++) {
				if(!aliveCList[j])continue;
				int[] curH = hList.get(i);
				int[] curC = cList.get(j);
				int curD = Math.abs(curH[0] - curC[0]) + Math.abs(curH[1] - curC[1]);
				minD = Math.min(minD, curD);
			}
			resultSum += minD;
		}
		return resultSum;
	}
	
}