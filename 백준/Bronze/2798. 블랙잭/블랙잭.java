import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	int[] arr = new int[N];
    	st = new StringTokenizer(br.readLine());
    	for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
    	Arrays.sort(arr);
    	int max = Integer.MIN_VALUE;
    	for (int x = 0; x < N - 2; x++) {
    		int X = arr[x];
			for (int y = x + 1; y < N - 1; y++) {
				int Y = arr[y];
				for (int z = y + 1; z < N; z++) {
					int Z = arr[z];
					if(X + Y + Z > M)break;
					max = Math.max(max,  X + Y + Z);
				}
			}
		}
    	System.out.println(max);
    }
}