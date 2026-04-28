import java.io.*;
import java.util.*;

public class Main {
	
	static int N, Q;
	static int[] arr;
	static int[] addXor;
	static int[][] map;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        arr = new int[N];
        addXor = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
        addXor[1] = arr[1];
        for (int i = 2; i < N; i++) {
			addXor[i] = addXor[i-1] ^ arr[i];
		}
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
        	st = new StringTokenizer(br.readLine());
        	int type = Integer.parseInt(st.nextToken());
        	if(type == 0) {
        		int x = Integer.parseInt(st.nextToken());
        		int y = Integer.parseInt(st.nextToken());
        		sb.append(addXor[x-1] ^ addXor[y-1]).append('\n');
        	}else {
        		int x = Integer.parseInt(st.nextToken());
        		int y = Integer.parseInt(st.nextToken());
        		int d = Integer.parseInt(st.nextToken());
        		sb.append(addXor[x-1] ^ addXor[y-1] ^ d).append('\n');
        	}
		}
        System.out.println(sb);
    }
}
