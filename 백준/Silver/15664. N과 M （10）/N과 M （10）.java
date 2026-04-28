import java.util.*;
import java.io.*;

public class Main {
	
	static int N;
	static int M;
	static int[] arr;
	static int[] result;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		result = new int[M];
		visited = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		func(0, 0);
		System.out.println(sb.toString());
	}
	
	static void func(int start, int cnt) {
		if(cnt == M) {
			String na = Arrays.toString(result);
			for (int i = 0; i < M; i++)sb.append(result[i]).append(' ');
			sb.append('\n');
			return;
		}
		int prev = Integer.MIN_VALUE;
		for (int i = start; i < N; i++) {
			if(visited[i]) continue;
			if(arr[i] == prev) continue;
			visited[i] = true;
			result[cnt] = arr[i];
			prev = arr[i];
			func(i, cnt+1);
			visited[i] = false;
		}
	}

}