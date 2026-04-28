import java.util.*;
import java.io.*;

class Main {
	static int K;
	static Gear[] gears = new Gear[4];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String args[]) throws Exception	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int i = 0; i < 4; i++) {
			String s = br.readLine();
			gears[i] = new Gear();
			for (int j = 0; j < 8; j++) {
				gears[i].list.add(s.charAt(j) - '0');
			}
		}
		K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int gearNum = Integer.parseInt(st.nextToken()) - 1;
			int magDir = Integer.parseInt(st.nextToken());
			int rightIndex = 1;
			int leftIndex = 1;
			if(magDir == 1) {
				gears[gearNum].turnRight();	
				while(gearNum + rightIndex < 4) {
					int x = rightIndex % 2 == 1 ? 1 : -1;
					if(gears[gearNum + rightIndex].getLeft() == gears[gearNum + rightIndex - 1].list.get(2 + x)) break;
					if(rightIndex % 2 == 0) {
  						gears[gearNum + rightIndex].turnRight();
					} else gears[gearNum + rightIndex].turnLeft();
					rightIndex++;
				}	
				while(gearNum - leftIndex >= 0) {
					int x = leftIndex % 2 == 1 ? 1 : -1;
					if(gears[gearNum - leftIndex].getRight() == gears[gearNum - leftIndex + 1].list.get(6 + x)) break;
					if(leftIndex % 2 == 0) {
  						gears[gearNum - leftIndex].turnRight();
					} else gears[gearNum - leftIndex].turnLeft();
					leftIndex++;
				}	
			} else {
				gears[gearNum].turnLeft();
				while(gearNum + rightIndex < 4) {
					int x = rightIndex % 2 == 0 ? 1 : -1;
					if(gears[gearNum + rightIndex].getLeft() == gears[gearNum + rightIndex - 1].list.get(2 + x)) break;
					if(rightIndex % 2 == 0) {
  						gears[gearNum + rightIndex].turnLeft();
					} else gears[gearNum + rightIndex].turnRight();
					rightIndex++;
				}	
				while(gearNum - leftIndex >= 0) {
					int x = leftIndex % 2 == 0 ? 1 : -1;
					if(gears[gearNum - leftIndex].getRight() == gears[gearNum - leftIndex + 1].list.get(6 + x)) break;
					if(leftIndex % 2 == 0) {
  						gears[gearNum - leftIndex].turnLeft();
					} else gears[gearNum - leftIndex].turnRight();
					leftIndex++;
				}	
			}
		}
		int sum = 0;
		for (int i = 0; i < 4; i++) {
			int score = gears[i].list.getFirst();
			if(score == 0) continue;
			score = score << i;
			sum += score;
		}
		System.out.println(sum);
	}
	static class Gear{
		LinkedList<Integer> list = new LinkedList<>();
		
		void turnRight() {
			list.addFirst(list.getLast());
			list.removeLast();
		}
		void turnLeft() {
			list.addLast(list.getFirst());
			list.removeFirst();
		}
		int getRight() {
			return list.get(2);
		}
		int getLeft() {
			return list.get(6);
		}
	}
}