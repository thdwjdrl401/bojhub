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
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < R; i++){
			int cmd = Integer.parseInt(st.nextToken());
			if(cmd == 1) {
				cmd1();
			} else if(cmd == 2) {
				cmd2();
			} else if(cmd == 3) {
				cmd3();
			} else if(cmd == 4) {
				cmd4();
			} else if(cmd == 5) {
				cmd5();
			} else if(cmd == 6) {
				cmd6();
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				sb.append(map[i][j] ).append(' ');
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
	
	private static void cmd1() {
//		for (int r = 0; r < R % 2; r++) {
			for (int i = 0; i < map.length / 2; i++) {
				for (int j = 0; j < map[0].length; j++) {
					int tmp = map[i][j];
					map[i][j] = map[map.length - 1 - i][j];
					map[map.length - 1 - i][j] = tmp;
				}
			}			
//		}
	}
	
	private static void cmd2() {
//		for (int r = 0; r < R % 2; r++) {
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[0].length / 2; j++) {
					int tmp = map[i][j];
					map[i][j] = map[i][map[0].length - 1 - j];
					map[i][map[0].length - 1 - j] = tmp;
				}
			}			
//		}
	}
	
	private static void cmd3() {
//		for (int r = 0; r < R % 4; r++) {
			int[][] tmpMap = new int[map[0].length][map.length];
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[0].length; j++) {
					tmpMap[j][map.length - 1 - i] = map[i][j];
				}
			}
			map = tmpMap;
//		}
	}
	
	private static void cmd4() {
//		for (int r = 0; r < R % 4; r++) {
			int[][] tmpMap = new int[map[0].length][map.length];
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[0].length; j++) {
					tmpMap[map[0].length - 1 - j][i] = map[i][j];
				}
			}
			map = tmpMap;
//		}
	}
	
	private static void cmd5() {
//		for (int r = 0; r < R % 4; r++) {
			for (int i = 0; i < map.length / 2; i++) {
				for (int j = 0; j < map[0].length / 2; j++) {
					int tmp = map[i][j];
					map[i][j] = map[i][map[0].length / 2 + j];
					map[i][map[0].length / 2 + j] = tmp;
				}
			}
			for (int i = 0; i < map.length / 2; i++) {
				for (int j = 0; j < map[0].length / 2; j++) {
					int tmp = map[i][j];
					map[i][j] = map[map.length / 2 + i][j];
					map[map.length / 2 + i][j] = tmp;
				}
			}
			for (int i = map.length / 2; i < map.length; i++) {
				for (int j = 0; j < map[0].length / 2; j++) {
					int tmp = map[i][j];
					map[i][j] = map[i][map[0].length / 2 + j];
					map[i][map[0].length / 2 + j] = tmp;
				}
			}
//		}
	}

	private static void cmd6() {
//		for (int r = 0; r < R % 4; r++) {
			for (int i = 0; i < map.length / 2; i++) {
				for (int j = 0; j < map[0].length / 2; j++) {
					int tmp = map[i][j];
					map[i][j] = map[map.length / 2 + i][j];
					map[map.length / 2 + i][j] = tmp;
				}
			}
			for (int i = 0; i < map.length / 2; i++) {
				for (int j = 0; j < map[0].length / 2; j++) {
					int tmp = map[i][j];
					map[i][j] = map[i][map[0].length / 2 + j];
					map[i][map[0].length / 2 + j] = tmp;
				}
			}
			for (int i = 0; i < map.length / 2; i++) {
				for (int j = map[0].length / 2; j < map[0].length; j++) {
					int tmp = map[i][j];
					map[i][j] = map[map.length / 2 + i][j];
					map[map.length / 2 + i][j] = tmp;
				}
			}
//		}
	}
}