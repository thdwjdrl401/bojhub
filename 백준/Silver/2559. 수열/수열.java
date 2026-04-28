import java.io.*;
import java.util.*;

public class Main {
	
	static int N, K;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		
		int cur = 0;
		for (int i = 0; i < K; i++) {
			cur += arr[i];
		}
		int max = cur;
		int index = 0;
		while(index + K != N) {
			cur -= arr[index];
			cur += arr[index + K];
			index++;
			max = Math.max(max, cur);
		}
		System.out.println(max);
	}
}
