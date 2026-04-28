import java.util.*;
import java.io.*;

public class Main {
	
	static int[][] map;
	static int N;
	static int M;
	static int K;
	static boolean[] visited;
	static Op[] ops;
	static int[] order;
	static int answer;
	
	static class Op {
		int r, c, s;
		Op(int r, int c, int s){
			this.r = r;
			this.c = c;
			this.s = s;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());	
			}
		}
		
		ops = new Op[K];
		visited = new boolean[K];
		answer = Integer.MAX_VALUE;
		order = new int[K];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			ops[i] = new Op(r, c, s);
		}
		
		perm(0);

//		for (int i = 0; i < N; i++) {
//			int sum = 0;
//			for (int j = 0; j < M; j++) {
//				sum+=map[i][j];
//			}
//			min = Math.min(min, sum);
//		}
		System.out.println(answer);
	}
	
	static void perm(int cnt) {
		if(cnt == K) {
			simulate();
			return;
		}
		for (int i = 0; i < K; i++) {
			if(visited[i]) continue;
			visited[i] = true;
	        order[cnt] = i;
			perm(cnt + 1);
			visited[i] = false;
		}
	}
    static void simulate() {
        int[][] a = copyMap(map);

        for (int idx : order) {
            Op op = ops[idx];
            rotation(a, op.r, op.c, op.s); // list 방식 회전
        }

        answer = Math.min(answer, minRowSum(a));
    }
    static int minRowSum(int[][] a) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            int sum = 0;
            for (int j = 0; j < a[0].length; j++) sum += a[i][j];
            min = Math.min(min, sum);
        }
        return min;
    }
    static int[][] copyMap(int[][] src) {
        int[][] dest = new int[src.length][src[0].length];
        for (int i = 0; i < src.length; i++) dest[i] = src[i].clone();
        return dest;
    }
	private static void rotation(int[][] tmpMap, int r, int c, int s) {
		for (int i = 1; i <= s; i++) {
			List<Integer> list = new ArrayList<>();
			int top = r - i - 1;
			int right = c + i - 1;
			int bottom = r + i - 1;
			int left = c - i - 1;
			for (int j = left; j <= right; j++) list.add(tmpMap[top][j]);
			for (int j = top + 1; j <= bottom; j++) list.add(tmpMap[j][right]);
			for (int j = right - 1; j >= left; j--) list.add(tmpMap[bottom][j]);
			for (int j = bottom - 1; j >= top + 1; j--) list.add(tmpMap[j][left]);
			
			int len = list.size();
			int index = list.size() - 1;
			for (int j = left; j <= right; j++) tmpMap[top][j] = list.get(index++ % len);
			for (int j = top + 1; j <= bottom; j++) tmpMap[j][right] = list.get(index++ % len);
			for (int j = right - 1; j >= left; j--) tmpMap[bottom][j] = list.get(index++ % len);
			for (int j = bottom - 1; j >= top + 1; j--) tmpMap[j][left] = list.get(index++ % len);
			
		}
	}
}
