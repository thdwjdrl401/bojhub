import java.io.*;
import java.util.*;

public class Main {

	static int R, C, M;
	static int[][] map;
	static Deque<int[]> sdq = new ArrayDeque<>();
	static int[] dr = {0, -1, 1, 0, 0};
	static int[] dc = {0, 0, 0, 1, -1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[R + 1][C + 1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			sdq.offer(new int[] {r, c, s, d, z});
			map[r][c] = z;
		}
		int index = 0;
		int result = 0;
		while(index <= C -1) {
			// 낚시왕이 오른쪽으로 한 칸 이동한다.
			index++;			
			
			// 낚시왕이 있는 열에 있는 상어 중에서 땅과 제일 가까운 상어를 잡는다. 상어를 잡으면 격자판에서 잡은 상어가 사라진다.
			for (int i = 1; i <= R; i++) {
				if(map[i][index] != 0) {
					result += map[i][index];
					map[i][index] = 0;
					break;
				}
			}
			
			// 상어가 이동한다.
			sharkMove();
		}
		System.out.println(result);
	}
	
	// return: {newR, newC, newD}
	static int[] moveSharkO1(int r, int c, int s, int d) {
	    int newR = r;
	    int newC = c;

	    // 위/아래 이동
	    if (d == 1 || d == 2) {
	        if (R == 1) return new int[]{1, c, d};

	        int cycle = 2 * (R - 1);
	        int move = s % cycle;

	        // x: "펼쳐진" 위치 (0 ~ cycle-1)
	        // 아래면 그대로, 위면 뒤집어서 표현
	        int x = (d == 2) ? (r - 1) : (cycle - (r - 1));

	        // move만큼 이동
	        x = (x + move) % cycle;

	        // 다시 접어서 newR과 방향 결정
	        if (x <= R - 1) {
	            newR = x + 1;
	            d = 2; // 아래
	        } else {
	            newR = cycle - x + 1;
	            d = 1; // 위
	        }
	        newC = c;
	    }
	    // 왼/오 이동
	    else {
	        if (C == 1) return new int[]{r, 1, d};

	        int cycle = 2 * (C - 1);
	        int move = s % cycle;

	        int x = (d == 3) ? (c - 1) : (cycle - (c - 1));
	        x = (x + move) % cycle;

	        if (x <= C - 1) {
	            newC = x + 1;
	            d = 3; // 오른
	        } else {
	            newC = cycle - x + 1;
	            d = 4; // 왼
	        }
	        newR = r;
	    }

	    return new int[]{newR, newC, d};
	}
	
	static void sharkMove() {
		int[][] newMap = new int[R + 1][C + 1];
		Deque<int[]> nsdq = new ArrayDeque<>();
		while(!sdq.isEmpty()) {
			int[] cur = sdq.poll();
			int r = cur[0];
			int c = cur[1];
			int s = cur[2];
			int d = cur[3];
			int z = cur[4];
			if(map[r][c] != z) continue;
			
			int[] moved = moveSharkO1(r, c, s, d);
			int nr = moved[0];
			int nc = moved[1];
			d = moved[2];
			
			// 이동 확정: 기존 상어 여부 확인
			if(newMap[nr][nc] != 0) {
				if(newMap[nr][nc] < z) {
					newMap[nr][nc] = z;
				}else {
					// 망. 잡아먹힘
					continue;
				}
			}else {
				newMap[nr][nc] = z;
			}
			nsdq.offer(new int[] {nr, nc, s, d, z});
		}
		sdq = nsdq;
		map = newMap;
	}
	
	static boolean check(int r, int c) {
		return r <= R && c <= C && r >= 1 && c >= 1;
	}
}