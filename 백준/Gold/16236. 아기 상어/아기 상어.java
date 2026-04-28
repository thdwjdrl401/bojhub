import java.util.*;
import java.io.*;

class Main {
	static int N;
	static int[][] map;
	static StringBuilder sb = new StringBuilder();
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, -1, 0, 1};
	static int level = 2;
	static int xp = 0;
	static int cr, cc;
	static List<Fish> list = new ArrayList<>();
	
	public static void main(String args[]) throws Exception	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if(map[r][c] == 9) {
					cr = r;
					cc = c;
					map[r][c] = 0;
				} else if(map[r][c] != 0){
					list.add(new Fish(r, c, map[r][c]));
				}
			}
		}
		int time = 0;
		Fish curFish = new Fish(cr, cc, 2);
		Target target = getNextTarget(curFish);
//		System.out.println(target);
		while (target.fish != null && target.time != -1) {
			time += target.time;
			curFish.eatFish(target.fish);
//			curFish.printMap();
//			System.out.println();
		    removeFish(target.fish);
			target = getNextTarget(curFish);
		}

		System.out.println(time);
		
	}
	
	static class Target{
		Fish fish;
		int time;
		public Target(Fish f, int t) {
			this.fish = f;
			this.time = t;
		}
		@Override
		public String toString() {
			return "Target [fish=" + fish + ", time=" + time + "]";
		}
	}
	
	static class Fish{
		int r, c, size, xp = 0;

		public Fish(int r, int c, int size) {
			super();
			this.r = r;
			this.c = c;
			this.size = size;
		}
		 
		public void eatFish(Fish f) {
			if(++xp >= size) {
				xp = 0;
				size++;
			}
			this.r = f.r;
			this.c = f.c;
		}

		@Override
		public String toString() {
			return "Fish [r=" + r + ", c=" + c + ", size=" + size + ", xp=" + xp + "]";
		}
		
		public void printMap() {
			System.out.println(this.xp + " / " + this.size);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(this.r == i && this.c == j) System.out.print("X ");
					else System.out.print("O ");
				}
				System.out.println();
			}
		}
	}
	
	static void removeFish(Fish f) {
	    if(list.contains(f)) list.remove(f);
	}


//	다음 타겟을 찾는 메서드
	static Target getNextTarget(Fish curFish) {
		int min = Integer.MAX_VALUE;
		Fish targetFish = null;
		for(Fish s : list){
			if(curFish.size <= s.size) continue;
			int time = getShortTime(curFish, s);
			if(time == -1) continue;
			if(min > time) {
				min = time;
				targetFish = s;
			} else if(targetFish != null && min == time) {
				if(targetFish.r > s.r) targetFish = s;
				else if (targetFish.r == s.r) {
					if(targetFish.c > s.c) targetFish = s;
				}
			}
		}
		return new Target(targetFish, min);
	}
	
//	bfs로 target까지 가는 최단거리 계산하는 메서드
	private static int getShortTime(Fish curFish, Fish targetFish) {
		Deque<int[]> dq = new ArrayDeque<>();
		int time = 0;
		dq.offer(new int[] {curFish.r, curFish.c, time});
		boolean[][] visited = new boolean[N][N];
		visited[curFish.r][curFish.c] = true;
		while(!dq.isEmpty()) {
			int[] cur = dq.poll();
			time = cur[2];
			if(cur[0] == targetFish.r && cur[1] == targetFish.c) return time;
			for (int i = 0; i < 4; i++) {
				int nr = cur[0] + dr[i];
				int nc = cur[1] + dc[i];
				if(!check(nr, nc)) continue;
				if(map[nr][nc] > curFish.size) continue;
				if(visited[nr][nc]) continue;
				visited[nr][nc] = true;
				dq.offer(new int[] {nr, nc, time + 1});
			}
		}
	return -1;
}

	static boolean check(int nr, int nc) {
		return nr >= 0 && nc >= 0 && nr < N && nc < N;
	}
}