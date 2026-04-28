import java.io.*;
import java.util.*;

public class Main {
	
	static int N, K;
	static int[] arr;

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		arr = new int[K];
		long high = 0;
		for (int i = 0; i < K; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			high = Math.max(high, arr[i]);
		}
		
		long low = 1;
		while(low <= high) {
			long mid = low + (high - low) / 2;
			long getCount = getCount(mid); 
			
			if(getCount >= N) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		
		System.out.println(high);
	}
	
	static long getCount(long n) {
		long result = 0;
		for (int i = 0; i < arr.length; i++) {
			result += arr[i] / n;
			if(result >= N) return result;
		}
		return result;
	}
}
