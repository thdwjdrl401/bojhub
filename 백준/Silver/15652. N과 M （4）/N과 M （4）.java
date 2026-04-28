import java.util.*;
import java.io.*;

public class Main {
	
	static int N;
	static int M;
	static int[] arr;
	static int[] result;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		result = new int[M];
		for (int i = 0; i < N; i++)arr[i] = i+1;
		
		func(0);
		System.out.println(sb.toString());
	}
	
	static void func(int cnt) {
		if(cnt == M) {
			for (int i = 0; i < M; i++)sb.append(result[i]).append(' ');
			sb.append('\n');
			return;
		}
		for (int i = cnt == 0 ? 0 : result[cnt - 1] - 1; i < N; i++) {
			result[cnt] = arr[i];
			func(cnt+1);
			result[cnt] = 0;
		}
	}

}