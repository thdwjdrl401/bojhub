import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int result = 0;
		int[][] counter = new int[2][6];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			counter[S][Y - 1]++;
		}
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 6; j++) {
				result += counter[i][j] / K;
				if(counter[i][j] % K != 0) result++;
			}
		}
		System.out.println(result);
	}

}
