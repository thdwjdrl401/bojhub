import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int S;
	static int[] arr;
	static int left;
	static int right;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		left = 0;
		right = 0;
		int sum = arr[0];
		int min = Integer.MAX_VALUE;
		while(true) {
			if(sum >= S) {
				min = Math.min(min, right - left + 1);
				if(left < right) sum -= arr[left];
				else if(left == right) {
					if(right == N - 1) break;
					sum += arr[right + 1];
					right++;
					continue;
				}
				left++;
			}else {
				if(right == N - 1) break;
				sum += arr[right + 1];
				right++;
			}
		}
		System.out.println(min == Integer.MAX_VALUE ? 0 : min);
	}
}