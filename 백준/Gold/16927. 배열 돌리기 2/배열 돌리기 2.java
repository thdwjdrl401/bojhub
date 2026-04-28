import java.util.*;
import java.io.*;

public class Main {
	
	static int N;
	static int M;
	static int R;
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		rotation();
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(map[i][j] ).append(' ');
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
	private static void rotation() {
		
		int layer = Math.min(N, M) / 2;
		for (int i = 0; i < layer; i++) {
			List<Integer> list = new ArrayList<>();	
			int top = i;
			int left = i;
			int right = M - i -1;
			int bottom = N - i - 1;
			// top list 추출
			for (int j = left; j <= right; j++) list.add(map[top][j]);
			
			// right list 추출
			for (int j = top + 1; j <= bottom; j++) list.add(map[j][right]);
			
			// bottom list 추출
			for (int j = right - 1; j >= left; j--) list.add(map[bottom][j]);
			
			// left list 추출
			for (int j = bottom - 1; j >= top + 1; j--) list.add(map[j][left]);

			int len = list.size();
			int idx = R % len;
			
			for (int j = left; j <= right; j++) map[top][j] = list.get(idx++ % len);
			for (int j = top + 1; j <= bottom; j++) map[j][right] = list.get(idx++ % len);
			for (int j = right - 1; j >= left; j--) map[bottom][j] = list.get(idx++ % len);
			for (int j = bottom - 1; j >= top + 1; j--) map[j][left] = list.get(idx++ % len);
		}
	}
}