import java.io.*;
import java.util.*;

public class Main {

	static int[][] map = new int[9][9];
	static List<int[]> list = new ArrayList<>();
	static Set<Integer>[] rSet = new HashSet[9];
	static Set<Integer>[] cSet = new HashSet[9];
	static Set<Integer>[][] rcSet = new HashSet[3][3];
    static boolean solved = false;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 9; i++) {
			rSet[i] = new HashSet<>();
			cSet[i] = new HashSet<>();
		}
        for (int a = 0; a < 3; a++) for (int b = 0; b < 3; b++) rcSet[a][b] = new HashSet<>();
		for (int i = 0; i < 9; i++) {
			String s = br.readLine();
			for (int j = 0; j < 9; j++) {
				map[i][j] = Integer.parseInt(s.substring(j, j + 1));
				if(map[i][j] == 0) list.add(new int[] {i, j});
				else {
					rSet[i].add(map[i][j]);
					cSet[j].add(map[i][j]);
					rcSet[i / 3][j / 3].add(map[i][j]);					
				}
			}
		}
		dfs(0);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				sb.append(map[i][j]);
			}
			sb.append('\n');
		}
		System.out.println(sb);
		
	}
	
	static void dfs(int depth) {
        if (solved) return;
		if(depth == list.size()) {
            solved = true;
            return;
		}
		
		int[] cur = list.get(depth);
		int r = cur[0];
		int c = cur[1];
		
		for (int j = 1; j <= 9; j++) {
			if(rSet[r].contains(j) || cSet[c].contains(j) || rcSet[r/3][c/3].contains(j)) continue;
			map[r][c] = j;	
			rSet[r].add(j);
			cSet[c].add(j);
			rcSet[r/3][c/3].add(j);
			dfs(depth + 1);
            if (solved) return;
			map[r][c] = 0;
			rSet[r].remove(j);
			cSet[c].remove(j);
			rcSet[r/3][c/3].remove(j);
		}
	}
}
