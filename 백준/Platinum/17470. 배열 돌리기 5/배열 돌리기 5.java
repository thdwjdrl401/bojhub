import java.util.*;
import java.io.*;

public class Main {
	
	static int N;
	static int M;
	static int R;
	static int[][] map;
	static String[][] m;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		m = new String[][] {{"1N", "2N"}, {"3N", "4N"}};
		//정상 : N, 상하반전 : W, 좌우반전 : C, 오른쪽 : R, 왼쪽 : L, 180도 : V, 뒤집고 돌리기 : A, 뒤집고 돌리기 : B
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < R; i++) {
			int cmd = Integer.parseInt(st.nextToken());
			mCmd(cmd);
		}
		int[][] result1 = result(m[0][0].charAt(0), m[0][0].charAt(1));
		int[][] result2 = result(m[0][1].charAt(0), m[0][1].charAt(1));
		int[][] result3 = result(m[1][0].charAt(0), m[1][0].charAt(1));
		int[][] result4 = result(m[1][1].charAt(0), m[1][1].charAt(1));
		
		StringBuilder sb = new StringBuilder();
		int h = result1.length;        // 블록의 실제 높이
		int w = result1[0].length;     // 블록의 실제 너비
		for (int i = 0; i < h; i++) {
		    for (int j = 0; j < w; j++) sb.append(result1[i][j]).append(' ');
		    for (int j = 0; j < w; j++) sb.append(result2[i][j]).append(' ');
		    sb.append('\n');
		}
		for (int i = 0; i < h; i++) {
		    for (int j = 0; j < w; j++) sb.append(result3[i][j]).append(' ');
		    for (int j = 0; j < w; j++) sb.append(result4[i][j]).append(' ');
		    sb.append('\n');
		}

		System.out.println(sb.toString());
		
	}
	static int[][] result(char position, char cmd){
		int[][] resultMap = new int[N / 2][M / 2];
		int top = 0, right = 0, bottom = 0, left = 0;
		if(position == '1') {
			top = 0;
			right = M / 2;
			bottom = N / 2;
			left = 0;
		} else if(position == '2') {
			top = 0;
			right = M;
			bottom = N / 2;
			left = M / 2;
		} else if(position == '3') {
			top = N / 2;
			right = M / 2;
			bottom = N;
			left = 0;
		} else if(position == '4') {
			top = N / 2;
			right = M;
			bottom = N;
			left = M / 2;
		}
		int indexR = 0, indexC = 0;
		for (int i = top; i < bottom; i++) {
			for (int j = left; j < right; j++) {
				resultMap[indexR][indexC] = map[i][j];
				indexC++;
			}
			indexR++;
			indexC = 0;
		}
		//정상 : N, 상하반전 : W, 좌우반전 : C, 오른쪽 : R, 왼쪽 : L, 180도 : V, 뒤집고 돌리기 : A, 뒤집고 돌리기 : B

		if(cmd == 'W') {
			resultMap = cmd1(resultMap);
		} else if(cmd == 'C') {
			resultMap = cmd2(resultMap);
		} else if(cmd == 'R') {
			resultMap = cmd3(resultMap);
		} else if(cmd == 'L') {
			resultMap = cmd4(resultMap);
		} else if(cmd == 'V') {
			resultMap = cmd3(resultMap);
			resultMap = cmd3(resultMap);
		} else if(cmd == 'A') {
			resultMap = cmd1(resultMap);
			resultMap = cmd3(resultMap);
		} else if(cmd == 'B') {
			resultMap = cmd1(resultMap);
			resultMap = cmd4(resultMap);
		}
		
		return resultMap;
	}
	static void mCmd(int cmd) {
		if(cmd < 5) {
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 2; j++) {
					char c = m[i][j].charAt(1);
					m[i][j] = String.valueOf(new char[] {m[i][j].charAt(0), mapper(c, cmd)});
				}
			}			
		}
		if(cmd == 1) {
			String[] tmp = new String[2];
			for (int i = 0; i < 2; i++) tmp[i] = m[0][i];
			for (int i = 0; i < 2; i++) m[0][i] = m[1][i];
			for (int i = 0; i < 2; i++) m[1][i] = tmp[i];
		}else if(cmd == 2) {
			String[] tmp = new String[2];
			for (int i = 0; i < 2; i++) tmp[i] = m[i][0];
			for (int i = 0; i < 2; i++) m[i][0] = m[i][1];
			for (int i = 0; i < 2; i++) m[i][1] = tmp[i];
		}else if(cmd == 3 || cmd == 5) {
			String tmp = m[0][0];
			m[0][0] = m[1][0];
			m[1][0] = m[1][1];
			m[1][1] = m[0][1];
			m[0][1] = tmp;
		}else if(cmd == 4 || cmd == 6) {
			String tmp = m[0][0];
			m[0][0] = m[0][1];
			m[0][1] = m[1][1];
			m[1][1] = m[1][0];
			m[1][0] = tmp;
		}
	}
	
	static char mapper(char c, int cmd) {
		if(c == 'N') {
			if(cmd == 1)return 'W';
			else if(cmd == 2)return 'C';
			else if(cmd == 3)return 'R';
			else if(cmd == 4)return 'L';
		} else if(c == 'W') {
			if(cmd == 1)return 'N';
			else if(cmd == 2)return 'V';
			else if(cmd == 3)return 'A';
			else if(cmd == 4)return 'B';
		} else if(c == 'C') {
			if(cmd == 1)return 'V';
			else if(cmd == 2)return 'N';
			else if(cmd == 3)return 'B';
			else if(cmd == 4)return 'A';
		} else if(c == 'R') {
			if(cmd == 1)return 'B';
			else if(cmd == 2)return 'A';
			else if(cmd == 3)return 'V';
			else if(cmd == 4)return 'N';
		} else if(c == 'L') {
			if(cmd == 1)return 'A';
			else if(cmd == 2)return 'B';
			else if(cmd == 3)return 'N';
			else if(cmd == 4)return 'V';
		} else if(c == 'V') {
			if(cmd == 1)return 'C';
			else if(cmd == 2)return 'W';
			else if(cmd == 3)return 'L';
			else if(cmd == 4)return 'R';
		} else if(c == 'A') {
			if(cmd == 1)return 'L';
			else if(cmd == 2)return 'R';
			else if(cmd == 3)return 'C';
			else if(cmd == 4)return 'W';
		} else if(c == 'B') {
			if(cmd == 1)return 'R';
			else if(cmd == 2)return 'L';
			else if(cmd == 3)return 'W';
			else if(cmd == 4)return 'C';
		}
		return c;
	}
	

	private static int[][] cmd1(int[][] miniMap) {
		for (int i = 0; i < miniMap.length / 2; i++) {
			for (int j = 0; j < miniMap[0].length; j++) {
				int tmp = miniMap[i][j];
				miniMap[i][j] = miniMap[miniMap.length - 1 - i][j];
				miniMap[miniMap.length - 1 - i][j] = tmp;
			}
		}
		return miniMap;
	}
	
	private static int[][] cmd2(int[][] miniMap) {
		for (int i = 0; i < miniMap.length; i++) {
			for (int j = 0; j < miniMap[0].length / 2; j++) {
				int tmp = miniMap[i][j];
				miniMap[i][j] = miniMap[i][miniMap[0].length - 1 - j];
				miniMap[i][miniMap[0].length - 1 - j] = tmp;
			}
		}		
		return miniMap;
	}
	
	private static int[][] cmd3(int[][] miniMap) {
		int[][] tmpMap = new int[miniMap[0].length][miniMap.length];
		for (int i = 0; i < miniMap.length; i++) {
			for (int j = 0; j < miniMap[0].length; j++) {
				tmpMap[j][miniMap.length - 1 - i] = miniMap[i][j];
			}
		}
		miniMap = tmpMap;
		return miniMap;
	}
	
	private static int[][] cmd4(int[][] miniMap) {
		int[][] tmpMap = new int[miniMap[0].length][miniMap.length];
		for (int i = 0; i < miniMap.length; i++) {
			for (int j = 0; j < miniMap[0].length; j++) {
				tmpMap[miniMap[0].length - 1 - j][i] = miniMap[i][j];
			}
		}
		miniMap = tmpMap;
		return miniMap;
	}
}
//
//
//정상 : N
//1 2
//3 4
//
//상하반전 : W
//3 4
//1 2
//
//좌우반전 : C
//2 1
//4 3
//
//오른쪽 : R
//3 1
//4 2
//
//왼쪽 : L
//2 4
//1 3
//
//180도 : V
//4 3
//2 1
//
//뒤집고 돌리기 : A
//1 3
//2 4
//
//뒤집고 돌리기 : B
//4 2
//3 1