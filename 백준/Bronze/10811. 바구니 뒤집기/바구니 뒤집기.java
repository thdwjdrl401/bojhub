import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static int[] arr;

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N + 1];
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			arr[i] = i;
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			for (int j = 0; j < (b - a + 1) / 2; j++) {
				int tmp = arr[a + j];
				arr[a + j] = arr[b - j];
				arr[b - j] = tmp;
			}
		}
		
		for (int i = 1; i <= N; i++) {
			sb.append(arr[i] + " ");
		}
		System.out.println(sb);
	}
}
