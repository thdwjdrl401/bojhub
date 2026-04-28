import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static String[][] map;
    static int maxDepth = 15;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new String[N][];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int K = Integer.parseInt(st.nextToken());
        	maxDepth = Math.max(maxDepth, K);
        	map[i] = new String[K];
        	for (int j = 0; j < K; j++) {
        		String s = st.nextToken();
        		map[i][j] = s;
			}
        	list.add(i);
		}
        dfs(0, list);
        System.out.println(sb);

    }
    
    static void dfs(int depth, List<Integer> list) {
    	if(depth > maxDepth) {
    		return;
    	}
    	Map<String, List<Integer>> visited = new HashMap<>();
    	PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
    		@Override
    		public int compare(String a, String b) {
    			return a.compareTo(b);
    		}
    	});
    	for (int i : list) {
			if(map[i].length <= depth) continue;
			String cur = map[i][depth];
			if(visited.containsKey(cur)) {
				visited.get(cur).add(i);
				continue;
			}
			visited.put(cur, new ArrayList<>());
			visited.get(cur).add(i);
			pq.offer(cur);
		}
//    	if(depth > 0)
//    	System.out.println(pq);
    	while(!pq.isEmpty()) {
    		String s = pq.poll();
    		for(int i = 0; i < depth; i++) {
    			sb.append("--");
    		}
    		sb.append(s).append('\n');
    		dfs(depth + 1, visited.get(s));
    	}
    }
}