import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static List<Integer>[] list;
	static int[][] dp;
	static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
        	list[i]=  new ArrayList<>();
        }
        for (int i = 1; i < N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			list[u].add(v);
			list[v].add(u);
		}
        dp = new int[N + 1][2]; // [노드][0 : 얼리어답터가 아니다, 1 : 얼리어답터다] 이때 자식노드 중 얼리어답터 갯수
        visited = new boolean[N + 1];
        
        dfs(1);
        int result = Math.min(dp[1][0], dp[1][1]);
        System.out.println(result);
    }
    
    static void dfs(int cur) {
    	visited[cur] = true;

    	dp[cur][0] = 0;
    	dp[cur][1] = 1;
    	
    	for (int next : list[cur]) {
    		if(visited[next]) continue;
    		
    		dfs(next);
    		
    		dp[cur][0] += dp[next][1];
    		dp[cur][1] += Math.min(dp[next][0], dp[next][1]);
		}
    }
}