import java.util.*;
import java.io.*;

public class Main {
	
	static int n;
	static int d;
	static int[][] map;
	static boolean[][] x;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			map = new int[n][n];
			x = new boolean[n][n];
			setX();
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			func(d);
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					sb.append(map[i][j]).append(' ');
				}
				sb.append('\n');
			}
		}
		System.out.println(sb.toString());
	}
	static void func(int deg) {
		int t = n / 2;
		for (int i = 0; i < t; i++) {
			int top = i;
			int right = n -i - 1;
			int bottom = n - i - 1;
			int left = i;
			List<Integer> list = new ArrayList<>();
			for (int j = left; j <= right; j++) {
				if(x[top][j]) list.add(map[top][j]);
			}
			for (int j = top + 1; j <= bottom; j++) {
				if(x[j][right]) list.add(map[j][right]);
			}
			for (int j = right - 1; j >= left; j--) {
				if(x[bottom][j]) list.add(map[bottom][j]);
			}
			for (int j = bottom - 1; j > top; j--) {
				if(x[j][left]) list.add(map[j][left]);
			}
			int len = list.size();
			int rot = (deg / 45) % 8;
			if(rot < 0) rot = 8 + rot;
			int index = 0;
			
			for (int j = left; j <= right; j++) {
				if(x[top][j]) map[top][j] = list.get((len - rot + index++) % len);
			}
			for (int j = top + 1; j <= bottom; j++) {
				if(x[j][right]) map[j][right] = list.get((len - rot + index++) % len);
			}
			for (int j = right - 1; j >= left; j--) {
				if(x[bottom][j]) map[bottom][j] = list.get((len - rot + index++) % len);
			}
			for (int j = bottom - 1; j > top; j--) {
				if(x[j][left]) map[j][left] = list.get((len - rot + index++) % len);
			}
		}
	}
	static void setX() {
		for (int i = 0; i < n; i++) {
			x[i][i] = true;
			x[i][n - i - 1] = true;
			x[n / 2][i] = true;
			x[i][n / 2] = true;
		}
	}
}