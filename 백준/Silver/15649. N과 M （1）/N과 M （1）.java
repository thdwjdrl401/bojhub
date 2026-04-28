import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int M;
	static int[] arr;
	static int[] result;
	static boolean[] visited;
	static StringBuilder sb;
	
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	sb = new StringBuilder();
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	arr = new int[N];
    	visited = new boolean[N];
    	result = new int[M];
    	for (int i = 0; i < N; i++) arr[i] = i + 1;
    	func(0);
    	System.out.println(sb.toString());
    }
    
    private static void func(int cnt) {
    	if(cnt == M) {
    		for (int i = 0; i < M; i++) {
    			 sb.append(result[i] + " ");
    		}
    		sb.deleteCharAt(sb.length() - 1);
    		sb.append('\n');
    		return;
    	}
    	for (int i = 0; i < N; i++) {
    		int cur = arr[i];
    		if(visited[i]) continue;
    		result[cnt] = cur;
    		visited[i] = true;
			func(cnt + 1);
			result[cnt] = 0;
			visited[i] = false;
		}
    }
}
